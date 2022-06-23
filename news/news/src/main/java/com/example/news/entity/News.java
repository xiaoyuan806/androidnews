package com.example.news.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("news")
public class News {
@TableId(type = IdType.AUTO)
    private Long id;
    private String newssub;
    private String classify;
    private String text;
    private String author;
    private String imgpath;
    private  long userId;
}
