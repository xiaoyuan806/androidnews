package com.example.mynew;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mynew.entity.User;
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

public class loginactivity extends AppCompatActivity implements View.OnClickListener{
private EditText usernameT;
private EditText passwordT;
private Button btn_login;
private Button btn_regist;
    private SharedPreferences mSp;
    private SharedPreferences.Editor mEditor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginactivity);
        usernameT=findViewById(R.id.username);
        passwordT=findViewById(R.id.password);
        btn_login=findViewById(R.id.btn_login);
        btn_regist=findViewById(R.id.btn_register);
        btn_login.setOnClickListener(this);
        btn_regist.setOnClickListener(this);
        Intent intent=new Intent();
       SharedPreferences sharedPreferences=getSharedPreferences("loginactivity",MODE_PRIVATE);
       String username=sharedPreferences.getString("username",null);
       String password=sharedPreferences.getString("password",null);
        System.out.println(username);
       usernameT.setText(username);
       passwordT.setText(password);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_login:
                String username = usernameT.getText().toString().trim();
                String password = passwordT.getText().toString().trim();
                if (username.length()<=0 ||password.length()<=0)
                    Toast.makeText(loginactivity.this,"请正确输入",Toast.LENGTH_SHORT).show();
                else
                    login(username,password);
                return;
            case R.id.btn_register:
                Intent intent=new Intent(loginactivity.this,registerActivity.class);
                startActivity(intent);
                return;
        }
    }

    private void login(final String username, final String password) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                MediaType JSON = MediaType.parse("application/json;charset=utf-8");
                JSONObject jsonObject = new JSONObject();
                OkHttpClient httpClient = new OkHttpClient();
                try {
                    jsonObject.put("username",username);
                    jsonObject.put("password",password);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                RequestBody requestBody = RequestBody.create(JSON, String.valueOf(jsonObject));
                String url = "http://192.168.43.72:8081/User/login";
                Request request = new Request.Builder()
                        .url(url)
                        .post(requestBody)
                        .build();

                Call call = httpClient.newCall(request);
                call.enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {
                        System.out.println(call.toString());
                        Log.d("whq登录","失败了");
                        handler.sendEmptyMessage(0);
                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        String MyResult = response.body().string();
                        result res= new Gson().fromJson(MyResult, result.class);
//                        System.out.println(sss.getflag());
//                        System.out.println(sss.getObject());
                       ObjectMapper objectMapper=new ObjectMapper();
                       User user=objectMapper.convertValue(res.getObject(),User.class);
                       if(res.getflag()){
                           mSp=getPreferences(MODE_PRIVATE);
                           mEditor= mSp.edit();
                           mEditor.putLong("id",user.getId());
                           mEditor.putString("username",user.getUsername());
                           mEditor.putString("password",user.getPassword());
                           mEditor.apply();
                           handler.sendEmptyMessage(1);

                       }
                       else{

                           handler.sendEmptyMessage(0);
//                               Toast.makeText(loginactivity.this,"登录失败",Toast.LENGTH_SHORT).show();

                       }
//                        System.out.println(user.getPassword());
//                        Log.d("whq登录",response+"---------response---------");
//                        Log.d("whq登录",response.message()+"---------message---------");
//                        Log.d("whq登录",response.body().toString()+"------------------");
//                        Log.d("whq登录",MyResult+"-----------MyResult-------");
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
               Toast.makeText(getApplicationContext(), "登录失败", Toast.LENGTH_SHORT).show();
           }
          else if(msg.what==1){
               Intent it = new Intent(loginactivity.this, MainActivity.class);
               startActivity(it);
           }

        }

    };
}