package com.example.mynew.ui.dashboard;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mynew.R;
import com.example.mynew.databinding.FragmentDashboardBinding;
import com.example.mynew.entity.User;
import com.example.mynew.result.result;
import com.example.mynew.util.adapter;
import com.example.mynew.writeActivity;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class DashboardFragment extends Fragment implements View.OnClickListener{

    private FragmentDashboardBinding binding;
  private RecyclerView recyclerView;
  private adapter adapter;
  private List<User> userList;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        DashboardViewModel dashboardViewModel =
                new ViewModelProvider(this).get(DashboardViewModel.class);

        binding = FragmentDashboardBinding.inflate(inflater, container, false);
        View root = binding.getRoot();


       final Button mbtn=binding.btnPhoto;

         mbtn.setOnClickListener(this);


   initview();
   data();
//
         
        return root;
    }

    private void initevent() {
        adapter=new adapter(getContext(),userList);
        recyclerView.setAdapter(adapter);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
    }

    private void data() {
        userList=new ArrayList<User>();
        new Thread(new Runnable() {
            @Override
            public void run() {
                MediaType JSON = MediaType.parse("application/json;charset=utf-8");

                OkHttpClient httpClient = new OkHttpClient();
                String url = "http://192.168.43.72:8081/User/besTen";
                Request request = new Request.Builder()
                        .url(url)
                        .get()
                        .build();

                Call call = httpClient.newCall(request);
                call.enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {
                        System.out.println(call.toString());
                        Log.d("获取十佳数据","失败了");

                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        if(response.isSuccessful()){
                            String m=response.body().string();
                            System.out.println(m);
                            Type type=new TypeToken<ArrayList<User>>(){}.getType();
                            userList= (List<User>) new Gson().fromJson(m,type);
                            System.out.println(userList.get(1).getUsername());
                            handler.sendEmptyMessage(0);
                        }
                        else {
                            Log.d("获取十佳数据","失败了");
                        }
                    }
                });
            }
        }).start();


    }

    private void initview() {
        this.recyclerView= binding.recyclerview;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_photo:
                System.out.println(225);
                 Intent intent=new Intent(getActivity(), writeActivity.class);
      startActivity(intent);
        }
    }
    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            if (msg.what==0){
                initevent();
            }
        }};
}