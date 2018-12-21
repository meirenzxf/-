package com.example.day01.callback;

import com.example.day01.bean.MyData;

public interface MyCallBack {

    void setSuccess(MyData data);
    void setError(String error);
}
