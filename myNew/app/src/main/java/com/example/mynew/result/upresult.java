package com.example.mynew.result;

public class upresult {
    private int code;
    private String msg;
    private String path;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public upresult(int code, String msg, String path) {
        this.code = code;
        this.msg = msg;
        this.path = path;
    }

    public upresult() {
    }
}
