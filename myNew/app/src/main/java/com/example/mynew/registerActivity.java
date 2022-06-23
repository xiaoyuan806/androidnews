package com.example.mynew;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mynew.result.result;
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

public class registerActivity extends AppCompatActivity implements View.OnClickListener{
private EditText r_username;
private EditText r_password;
private Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
r_username=findViewById(R.id.r_username);
r_password=findViewById(R.id.r_password);
submit=findViewById(R.id.r_submit);
submit.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.r_submit:
                String username = r_username.getText().toString().trim();
                String password = r_password.getText().toString().trim();
                if (username.length()<=0 ||password.length()<=0)
                    Toast.makeText(registerActivity.this,"请正确输入",Toast.LENGTH_SHORT).show();
                else
                    register(username,password);
                return;

        }
    }

    private void register(String username,String password) {


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
                String url = "http://192.168.43.72:8081/User/register";
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

    Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            // TODO Auto-generated method stub
            if (msg.what == 0) {
                Toast.makeText(getApplicationContext(), "注册失败", Toast.LENGTH_SHORT).show();
            } else if (msg.what == 1) {
                Intent it = new Intent(registerActivity.this, loginactivity.class);
                startActivity(it);
            }

        }

    };
}