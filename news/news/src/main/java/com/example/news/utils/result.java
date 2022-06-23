package com.example.news.utils;

import com.example.news.entity.User;

public class result {
    private boolean flag;
    private User user;

    public result(boolean flag,  User user) {
        this.flag = flag;
        this.user = user;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public User getObject() {
        return user;
    }

    public void setObject(User user) {
        this.user = user;
    }
}
