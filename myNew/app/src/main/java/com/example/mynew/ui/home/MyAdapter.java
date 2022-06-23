package com.example.mynew.ui.home;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.mynew.R;
import com.example.mynew.entity.News;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private List<News> mBeanList;
    private Context mContext;
    private View inflater;

    public MyAdapter(Context context, List<News> mBeanList){
        this.mBeanList = mBeanList;
        this.mContext = context;
    }

    @Override
    public int getItemCount() {
        return mBeanList.size();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        inflater = LayoutInflater.from(mContext).inflate(R.layout.fragment_home_list,viewGroup,false);
        MyViewHolder myViewHolder = new MyViewHolder(inflater);
        return myViewHolder;
    }

    @SuppressLint("ResourceType")
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, @SuppressLint("RecyclerView") int position) {
        News news = mBeanList.get(position);
        holder.mTvTitle.setText(news.getNews_sub());

        Glide.with(mContext).load(news.getImgpath()).into(holder.mIvImage);


//        Random random = new Random();
//        int ran = random.nextInt(40)-10;
//        holder.mIvImage.setLayoutParams(new RelativeLayout.LayoutParams(dp2px(100),dp2px(100+ran)));

        holder.rlContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               News news1= mBeanList.get(position);
                Intent intent =new Intent(mContext,DetailActivity.class);
                intent.putExtra("title",news1.getNews_sub());
                intent.putExtra("content",news1.getText());
                intent.putExtra("image",news1.getImgpath());
                mContext.startActivity(intent);
            }
        });
    }

//    private int dp2px(int dp) {
//        final float scale = mContext.getResources().getDisplayMetrics().density;
//        return (int) (dp * scale + 0.5f);
//    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        TextView mTvTitle;
        TextView mTvContent;
        ImageView mIvImage;
        RelativeLayout rlContainer;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            this.mIvImage = itemView.findViewById(R.id.iv_img);
            this.mTvTitle = itemView.findViewById(R.id.tv_title);
            this.rlContainer = itemView.findViewById(R.id.rl_item_container);
        }
    }
}
