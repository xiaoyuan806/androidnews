package com.example.mynew.util;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mynew.R;
import com.example.mynew.entity.User;

import java.util.List;

public class adapter extends RecyclerView.Adapter<adapter.MyViewHolder> {
 private List<User> userList;
 private LayoutInflater layoutInflater;
 private Context context;
 public adapter(Context context,List<User> userList){
     this.context=context;
     this.userList=userList;
     layoutInflater=LayoutInflater.from(context);
 }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
     View view=layoutInflater.inflate(R.layout.rv_item,parent,false);
     MyViewHolder myViewHolder=new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
  User user=userList.get(position);
  holder.textView.setText(user.getUsername());
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
     TextView textView;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            this.textView=itemView.findViewById(R.id.tv);
        }
    }

}
