package com.example.mynew;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.mynew.entity.Memorandum;

import java.util.List;

public class MyAdapter extends BaseAdapter{
    private List<Memorandum> list;
    private Context context;
    public MyAdapter() {
    }
    public MyAdapter(List<Memorandum> list2, Context context) {
        this.list = list2;
        this.context = context;
//        System.out.println("this is MyAdapter contruct！！！");
    }

    @Override
    public int getCount() {
        System.out.println(list.size()+"11111");
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        System.out.println("this is MyAdapter！！！");
        if (convertView==null){
            convertView=LayoutInflater.from(context).inflate(R.layout.activity_list_item,parent,false);
        }
        TextView textView1=convertView.findViewById(R.id.textview2);
        TextView textView2=convertView.findViewById(R.id.textview4);
        textView1.setText(list.get(position).getAuthor().toString());
        textView2.setText(list.get(position).getContent().toString());
        return convertView;
    }
}
