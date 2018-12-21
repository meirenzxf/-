package com.example.day01.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.day01.R;
import com.example.day01.bean.MyData;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private ArrayList<MyData.DataBean> list;
    private Context context;
    private ViewHolder holder;

    public MyAdapter(ArrayList<MyData.DataBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recy_list, null);
        holder = new ViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        MyData.DataBean dataBean=list.get(position);
        holder.textRecy.setText(dataBean.getName());
    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView textRecy;
        private ImageView imageRecy;
        public ViewHolder(View itemView) {
            super(itemView);
            textRecy=itemView.findViewById(R.id.textRecy);
            imageRecy=itemView.findViewById(R.id.imageRecy);

        }
    }
}
