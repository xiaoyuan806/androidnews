package com.example.mynew.entity;

public class News {
    private long id;
    private String newssub;
    private String classify;
    private String text;
    private String author;
    private String imgpath;
    private  int userId;

    public News() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNews_sub() {
        return newssub;
    }

    public void setNews_sub(String news_sub) {
        this.newssub = news_sub;
    }

    public String getClassify() {
        return classify;
    }

    public void setClassify(String classify) {
        this.classify = classify;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getImgpath() {
        return imgpath;
    }

    public void setImgpath(String imgpath) {
        this.imgpath = imgpath;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public News(long id, String news_sub, String classify, String text, String author, String imgpath, int userId) {
        this.id = id;
        this.newssub = news_sub;
        this.classify = classify;
        this.text = text;
        this.author = author;
        this.imgpath = imgpath;
        this.userId = userId;
    }
}
