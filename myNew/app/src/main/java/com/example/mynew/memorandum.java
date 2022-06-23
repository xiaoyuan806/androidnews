package com.example.mynew;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mynew.result.result;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class memorandum extends AppCompatActivity {
    EditText editText1,editText2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memorandum);

    }

    public void onClick(View view) {
        editText1=findViewById(R.id.edt_UserName);
        editText2=findViewById(R.id.edt_text);
        String author=editText1.getText().toString();
        String text=editText2.getText().toString();
        SharedPreferences sp =getSharedPreferences("loginactivity", Context.MODE_PRIVATE);
        Long id=sp.getLong("id",1);
//        System.out.println(author+"  "+text+"   "+id);
        insertmem(author,text,id.intValue());
    }
    public void insertmem(String author,String text,int id){
        new Thread(new Runnable() {
            @Override
            public void run() {
                MediaType JSON = MediaType.parse("application/json;charset=utf-8");
                JSONObject jsonObject = new JSONObject();
                OkHttpClient httpClient = new OkHttpClient();
                try {
                    jsonObject.put("userid",id);
                    jsonObject.put("author",author);
                    jsonObject.put("content",text);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                RequestBody requestBody = RequestBody.create(JSON, String.valueOf(jsonObject));
                String url = "http://192.168.43.72:8081/Memorandum/insert";
                Request request = new Request.Builder()
                        .url(url)
                        .post(requestBody)
                        .build();

                Call call = httpClient.newCall(request);
                call.enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {
                        handler.sendEmptyMessage(0);
                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        String MyResult = response.body().string();
                        result res= new Gson().fromJson(MyResult, result.class);
//                        System.out.println(sss.getflag());
//                        System.out.println(sss.getObject());
                        ObjectMapper objectMapper=new ObjectMapper();
//                        User user=objectMapper.convertValue(res.getObject(),User.class);
                        if(res.getflag()){
                            handler.sendEmptyMessage(1);
                        }
                        else{
                            handler.sendEmptyMessage(0);
                        }
                    }
                });
            }
        }).start();
    }
    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            // TODO Auto-generated method stub
            if (msg.what==0){
                Toast.makeText(getApplicationContext(), "添加失败", Toast.LENGTH_SHORT).show();
            }
            else if(msg.what==1){
                Toast.makeText(getApplicationContext(), "添加成功", Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(memorandum.this,MainActivity.class);
                startActivity(intent);
            }

        }

    };
}