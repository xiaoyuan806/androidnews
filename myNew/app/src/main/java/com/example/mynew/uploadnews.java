package com.example.mynew;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mynew.entity.Memorandum;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class uploadnews extends AppCompatActivity {
    String con,aut;
    TextView textView;
    ListView listView;
    List<Memorandum> list=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uploadnews);
        SharedPreferences sp =getSharedPreferences("loginactivity", Context.MODE_PRIVATE);
        Long id=sp.getLong("id",1);
        Select(id.intValue());
    }
    public static <T> List<T> jsonToList(String json, Class<T> cls) {
        List<T> list = new ArrayList<T>();
        JsonArray array = new JsonParser().parse(json).getAsJsonArray();
        for(final JsonElement elem : array){
            list.add(new Gson().fromJson(elem, cls));
        }
        return list;
    }
    public void Select(int id){
        new Thread(new Runnable() {
            @Override
            public void run() {
                MediaType JSON = MediaType.parse("application/json;charset=utf-8");
                JSONObject jsonObject = new JSONObject();
                OkHttpClient httpClient = new OkHttpClient();
                try {
                    jsonObject.put("userid",id);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                RequestBody requestBody = RequestBody.create(JSON, String.valueOf(jsonObject));
                String url = "http://192.168.43.72:8081/Memorandum/Select";
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
                        try {
                            // Response对象存储的就是获取的数据
                            String data = response.body().string();
                            list = jsonToList(data,Memorandum.class);
                            System.out.println(list.size()+"接受的list长度");
                            listView=findViewById(R.id.listviewone);
                            MyAdapter myAdapter=new MyAdapter(list,uploadnews.this);
                            listView.setAdapter(myAdapter);
                            handler.sendEmptyMessage(1);
                        } catch (IOException e) {
                            e.printStackTrace();
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
                Toast.makeText(getApplicationContext(), "查询失败", Toast.LENGTH_SHORT).show();
            }
            else if(msg.what==1){
                Toast.makeText(getApplicationContext(), "查询成功", Toast.LENGTH_SHORT).show();
            }
        }
    };
}