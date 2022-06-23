package com.example.mynew;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
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

public class changepassword extends AppCompatActivity {
    EditText edit2,edit3;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_changepassword);
        SharedPreferences sp =getSharedPreferences("loginactivity", Context.MODE_PRIVATE);
        Long id=sp.getLong("id",1);
        textView=findViewById(R.id.edt_UserName);
        textView.setText(id.toString());
        textView.setTextSize(20);
    }
    public void login(String password){
        new Thread(new Runnable() {
            @Override
            public void run() {
                    SharedPreferences sp =getSharedPreferences("loginactivity", Context.MODE_PRIVATE);
                    Long id=sp.getLong("id",1);
                    MediaType JSON = MediaType.parse("application/json;charset=utf-8");
                    JSONObject jsonObject = new JSONObject();
                    OkHttpClient httpClient = new OkHttpClient();
                    try {
                        jsonObject.put("id",id.intValue());
                        jsonObject.put("password",password);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    RequestBody requestBody = RequestBody.create(JSON, String.valueOf(jsonObject));
                    String url = "http://192.168.43.72:8081/User/update";
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
//                            User user=objectMapper.convertValue(res.getObject(),User.class);
                            if(res.getflag()){
                                handler.sendEmptyMessage(1);
                            }
                            else{
                                handler.sendEmptyMessage(1);
//                               Toast.makeText(loginactivity.this,"登录失败",Toast.LENGTH_SHORT).show();
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
                Toast.makeText(getApplicationContext(), "修改失败", Toast.LENGTH_SHORT).show();
            }
            else if(msg.what==1){
                Toast.makeText(getApplicationContext(), "修改成功", Toast.LENGTH_SHORT).show();
                Intent it = new Intent(changepassword.this,loginactivity.class);
                startActivity(it);
            }

        }

    };
    public void onClick(View view) {

        edit2=findViewById(R.id.edt_NewPassWord);
        edit3=findViewById(R.id.edt_NewPassWord2);
        String password=edit2.getText().toString();
        String password2=edit3.getText().toString();
       if (password.equals(password2)){
        login(password);
         }else {
            Toast.makeText(this, "两次输入密码不一致", Toast.LENGTH_SHORT).show();
        }
    }
}