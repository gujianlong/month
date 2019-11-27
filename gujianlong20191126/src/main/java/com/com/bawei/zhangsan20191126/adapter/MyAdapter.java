package com.com.bawei.zhangsan20191126.adapter;
/*
 *@auther:谷建龙
 *@Date: 2019/11/27
 *@Time:9:34
 *@Description:
 * */


import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.com.bawei.zhangsan20191126.R;
import com.com.bawei.zhangsan20191126.bean.UserBean;
import com.com.bawei.zhangsan20191126.utils.GlideUtils;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<UserBean.ResultBean> list;

    public MyAdapter(Context context, List<UserBean.ResultBean> list) {

        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder holder = null;
        View view = null;
        view = View.inflate(context, R.layout.mylist, null);
        holder = new OneHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        if (holder instanceof OneHolder) {
            ((OneHolder) holder).name.setText(list.get(position).getCommodityName());
            GlideUtils.loadImage(list.get(position).getMasterPic(), ((OneHolder) holder).image);

        }
        //定义点击事件
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClick.onClick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class OneHolder extends RecyclerView.ViewHolder {

        private final ImageView image;
        private final TextView name;

        public OneHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image);
            name = itemView.findViewById(R.id.name);
        }
    }

    //定义接口回调
    public interface onItemClick {
        void onClick(int position);
    }

    public onItemClick onItemClick;

    public void setOnItemClick(MyAdapter.onItemClick onItemClick) {
        this.onItemClick = onItemClick;
    }
}
