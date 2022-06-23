package com.example.mynew;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;

import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

//import com.yalantis.ucrop.util.FileUtils;

import com.example.mynew.result.result;
import com.example.mynew.result.upresult;
import com.google.gson.Gson;
import com.yalantis.ucrop.util.FileUtils;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class writeActivity extends AppCompatActivity implements View.OnClickListener {
private Button select;
private Button submit;
private EditText sub;
private RadioGroup classi;
private EditText text;
private EditText author;
private File imagePath;
private long UsID;
private upresult upresult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write);
        select=findViewById(R.id.select);
        sub=findViewById(R.id.news_sub);
        classi=findViewById(R.id.classify);

        text=findViewById(R.id.news_con);
        author=findViewById(R.id.news_aut);
        select.setOnClickListener(this);
        submit=findViewById(R.id.news_submit);
        submit.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.select:
                Intent intent=new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");
                startActivityForResult(intent,1);
                return;
            case R.id.news_submit:
                 submit();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK && data != null) {
            Uri uri = data.getData();
            if (uri!=null) {
                handler.sendEmptyMessage(1);
            }

            try {
                saveUriToFile(uri);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

        }
        else
        {
            handler.sendEmptyMessage(0);
        }

    }

    private File saveUriToFile(Uri uri) throws FileNotFoundException {
        Bitmap bitmap = null;
        if (uri != null) {

                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inSampleSize = 2; // 图片宽高都为原来的二分之一，即图片为原来的四分之一
                bitmap = BitmapFactory.decodeStream(this.getContentResolver().openInputStream(uri), null, options);
                File file = null;
                   String filePath = FileUtils.getPath(this,uri);
//            System.out.println(filePath);
            File oldFile = new File(filePath);
            // 修改文件名
            String newFileName = UUID.randomUUID().toString().replace("-","")+".jpg";
            String newFilePath = oldFile.getParent()+"/"+newFileName;
            file = new File(newFilePath);
            oldFile.renameTo(file);
            System.out.println(file);
            imagePath=file;
            System.out.println(oldFile);
            handler.sendEmptyMessage(2);
            return imagePath;
    }
       return null;
}

Handler handler=new Handler(){
    @Override
    public void handleMessage(Message msg) {
        if (msg.what==1){
            Toast.makeText(getApplicationContext(), "上传成功", Toast.LENGTH_SHORT).show();
        }
        else if(msg.what==0){
            Toast.makeText(getApplicationContext(), "上传失败", Toast.LENGTH_SHORT).show();
        }
        else if(msg.what==2){
            System.out.println(568);
            upload(imagePath.getPath());
        }
        else if(msg.what==3){
          Toast.makeText(getApplicationContext(), "发送成功", Toast.LENGTH_SHORT).show();
            Intent intent=new Intent(writeActivity.this,MainActivity.class);
            startActivity(intent);
        }
    }
};


    public void submit(){
          SharedPreferences sharedPreferences=getSharedPreferences("loginactivity",MODE_PRIVATE);
      UsID= sharedPreferences.getLong("id",0);
      String subs=sub.getText().toString();
           int id=classi.getCheckedRadioButtonId();
           RadioButton radioButton=findViewById(classi.getCheckedRadioButtonId());
      String cla=radioButton.getText().toString();
      String txt=text.getText().toString();
      String autho=author.getText().toString();
      String imgpath=upresult.getPath();

        new Thread(new Runnable() {
            @Override
            public void run() {
                MediaType JSON = MediaType.parse("application/json;charset=utf-8");
                JSONObject jsonObject = new JSONObject();
                OkHttpClient httpClient = new OkHttpClient();
                try {
                    jsonObject.put("newssub",subs);
                    jsonObject.put("classify",cla);
                    jsonObject.put("text",txt);
                    jsonObject.put("author",autho);
                    jsonObject.put("imgpath",imgpath);
                    jsonObject.put("userId",UsID);

                } catch (JSONException e) {
                    e.printStackTrace();
                }
                RequestBody requestBody = RequestBody.create(JSON, String.valueOf(jsonObject));
                String url = "http://192.168.43.72:8081/News/addnew";
                Request request = new Request.Builder()
                        .url(url)
                        .post(requestBody)
                        .build();

                Call call = httpClient.newCall(request);
                call.enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {
                        Log.d("whq","失败了");
                        handler.sendEmptyMessage(0);
                    }


                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        Log.d("whq",response.toString()+"------------------");
                        String MyResult = response.body().string();
                        result res= new Gson().fromJson(MyResult, result.class);
                        System.out.println(res.getflag());
                        Log.d("whq",response.body().toString()+"------------------");
        if(res.getflag()){
            handler.sendEmptyMessage(3);
        }

                    }
                });

            }
        }).start();




    }
   public void upload(String path){

        new Thread(new Runnable() {
            @Override
            public void run() {
               try {

                   OkHttpClient httpClient = new OkHttpClient();
                   File file=new File(path);
                   MultipartBody.Builder reqbody=new MultipartBody.Builder().setType(MultipartBody.FORM);
                   RequestBody requestBody=RequestBody.create(MediaType.parse("image/*"),file);
                   reqbody.addFormDataPart("file",file.getName(),requestBody);
                   Request request=new Request.Builder().url("http://192.168.43.72:8081/News/add").post(reqbody.build()).build();
                   httpClient.newBuilder().readTimeout(5000, TimeUnit.MILLISECONDS).build().newCall(request).enqueue(new Callback() {
                       @Override
                       public void onFailure(Call call, IOException e) {
                           System.out.println("失败1");
                           Log.d("文件上传","失败了！");
                       }

                       @Override
                       public void onResponse(Call call, Response response) throws IOException {
                             if(response.isSuccessful()){
                                 String res=response.body().string();
                                upresult=new Gson().fromJson(res,upresult.class);
                                 System.out.println(upresult.getPath());


                             }else {
                                 System.out.println("失败2");
                                 Log.d("文件上传",response.message()+"error:body"+response.body().toString());
                             }
                       }
                   });
               }catch (Exception e){
                   e.printStackTrace();
               }
            }
        }).start();
   }
}