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

public class Xadapter extends RecyclerView.Adapter<Xadapter.ViewHolder> {

private ArrayList<MyData.DataBean> mlist;
private Context context;

    public Xadapter(ArrayList<MyData.DataBean> mlist, Context context) {
        this.mlist = mlist;
        this.context = context;
    }


    @NonNull
    @Override
    public Xadapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(context).inflate(R.layout.xrecy_list,null);
        ViewHolder holder=new ViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull Xadapter.ViewHolder holder, int position) {
    MyData.DataBean dataBean=mlist.get(position);
    holder.textXrecy.setText(dataBean.getCreatetime());
    }

    @Override
    public int getItemCount() {
        return mlist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView textXrecy;
        private ImageView imageXrey;
        public ViewHolder(View itemView) {
            super(itemView);
            textXrecy=itemView.findViewById(R.id.textXrecy);
            imageXrey=itemView.findViewById(R.id.imageXrey);

        }
    }
}
