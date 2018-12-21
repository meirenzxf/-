package com.example.day01.model;

import android.os.Handler;
import android.os.Message;

import com.example.day01.bean.MyData;
import com.example.day01.callback.MyCallBack;
import com.example.day01.util.OkHttps;
import com.google.gson.Gson;

import java.io.IOException;

public class ModelImpl implements Model{

    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case 0:
                    String jsonstr= (String) msg.obj;
                    Gson gson=new Gson();
                    MyData data= gson.fromJson(jsonstr,MyData.class);
                    callBack.setSuccess(data);

                    break;
            }
        }
    };
private MyCallBack callBack;
    @Override
    public void getData(final String mUrl,final int i, final MyCallBack callBack) {
        this.callBack=callBack;
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    String ok= OkHttps.getintent().get(mUrl,i);
                    handler.sendMessage(handler.obtainMessage(0,ok));


                } catch (IOException e) {
               callBack.setError(".......");
                }


            }
        }).start();

    }
}
