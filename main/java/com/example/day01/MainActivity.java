package com.example.day01;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.day01.adapter.MyAdapter;
import com.example.day01.adapter.Xadapter;
import com.example.day01.bean.MyData;
import com.example.day01.ivew.IVew;
import com.example.day01.pp.PerenerImpl;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements IVew {
    private String mUrl = "http://www.zhaoapi.cn/product/getCatagory?page=";
    private ArrayList<MyData.DataBean> list = new ArrayList<>();
    private ArrayList<MyData.DataBean> mlist = new ArrayList<>();
    private RecyclerView recy;
    private XRecyclerView xrecy;
    private PerenerImpl perener;
    private int i=1;
    private MyAdapter adapter;
    private GridLayoutManager manager;
    private Xadapter xadapter;
    private LinearLayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        perener = new PerenerImpl(this);
        perener.startRequest(mUrl,i);

        adapter = new MyAdapter(list,this);
        xadapter = new Xadapter(mlist,this);
        xrecy.setAdapter(xadapter);
        recy.setAdapter(adapter);

        manager = new GridLayoutManager(this,4);
        layoutManager = new LinearLayoutManager(this);
        xrecy.setLayoutManager(layoutManager);
        recy.setLayoutManager(manager);
    }

    @Override
    public void setSuccess(MyData data) {
        list.addAll(data.getData());
        mlist.addAll(data.getData());
        xrecy.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                mlist.clear();
                i=1;
                perener.startRequest(mUrl,i);
                xrecy.refreshComplete();
            }

            @Override
            public void onLoadMore() {
i++;
perener.startRequest(mUrl,i);
xrecy.refreshComplete();;
            }
        });
        adapter.notifyDataSetChanged();
    }

    @Override
    public void setError(String error) {

    }

    private void initView() {
        recy = (RecyclerView) findViewById(R.id.recy);
        xrecy = (XRecyclerView) findViewById(R.id.xrecy);
        xrecy.setPullRefreshEnabled(true);
        xrecy.setLoadingMoreEnabled(true);
    }
}
