package com.example.day01.pp;

import com.example.day01.bean.MyData;
import com.example.day01.callback.MyCallBack;
import com.example.day01.ivew.IVew;
import com.example.day01.model.ModelImpl;

public class PerenerImpl implements Perener{

    private IVew iVew;
    private ModelImpl model;

    public PerenerImpl(IVew iVew) {
        this.iVew = iVew;
        model=new ModelImpl();
    }

    @Override
    public void startRequest(String mUrl,int i) {
        model.getData(mUrl, i,new MyCallBack() {
            @Override
            public void setSuccess(MyData data) {
                iVew.setSuccess(data);
            }

            @Override
            public void setError(String error) {
iVew.setError(error);
            }
        });
    }
}
