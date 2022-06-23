package com.example.mynew.ui.home;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.mynew.R;

public class DetailActivity extends AppCompatActivity {
    TextView Title;
    TextView Content;
    ImageView Image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        String title=getIntent().getStringExtra("title");
        String content=getIntent().getStringExtra("content");
        String image=getIntent().getStringExtra("image");
        Title=findViewById(R.id.title);
        Content=findViewById(R.id.content);
        Image=findViewById(R.id.image);
        Title.setText(title);
        Content.setText(content);
        Glide.with(this).load(image).into(Image);

    }

}