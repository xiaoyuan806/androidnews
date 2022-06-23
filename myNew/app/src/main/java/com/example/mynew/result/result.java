package com.example.mynew.result;

public class result {
    private boolean flag;
    private Object object;

    public result(boolean flag, Object object) {
        this.flag = flag;
        this.object = object;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public Object getObject() {
        return object;
    }
public boolean getflag(){
        return flag;
}

    public void setObject(Object object) {
        this.object = object;
    }
}
