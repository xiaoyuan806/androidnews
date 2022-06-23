package com.example.mynew.ui.notifications;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.mynew.changepassword;
import com.example.mynew.databinding.FragmentNotificationsBinding;
import com.example.mynew.memorandum;
import com.example.mynew.uploadnews;


public class NotificationsFragment extends Fragment {

    private FragmentNotificationsBinding binding;
    private SharedPreferences mSp;
    private SharedPreferences.Editor mEditor;
    TextView textView,textView1,textView2,textView3;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        NotificationsViewModel notificationsViewModel =
                new ViewModelProvider(this).get(NotificationsViewModel.class);

        binding = FragmentNotificationsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        SharedPreferences  sp =container.getContext().getSharedPreferences("loginactivity",Context.MODE_PRIVATE);
        String data = sp.getString("username","未取到用户信息");
        textView=binding.textView;
        textView.setText("你好，"+data);
        textView1=binding.textView6;
        textView2=binding.textView7;
        textView3=binding.textView8;
        textView1.setClickable(true);
        textView2.setClickable(true);
        textView3.setClickable(true);
        textView1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getActivity(), memorandum.class);
                startActivity(i);
            }
        });
        textView2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getActivity(), uploadnews.class);
                startActivity(i);
            }
        });
        textView3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getActivity(), changepassword.class);
                startActivity(i);
            }
        });
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}