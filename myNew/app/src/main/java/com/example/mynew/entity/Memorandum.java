package com.example.mynew.entity;

public class Memorandum {
    private int userid;
    private String content;
    private String author;

    public Memorandum() {

    }

    public Memorandum(int userid, String content, String author) {
        this.userid = userid;
        this.content = content;
        this.author = author;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getUserid() {
        return userid;
    }

    public String getContent() {
        return content;
    }

    public String getAuthor() {
        return author;
    }
}
