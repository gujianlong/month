package com.com.bawei.zhangsan20191126;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.com.bawei.zhangsan20191126.adapter.MyAdapter;
import com.com.bawei.zhangsan20191126.base.BaseActivity;
import com.com.bawei.zhangsan20191126.base.BasePresenter;
import com.com.bawei.zhangsan20191126.bean.UserBean;
import com.com.bawei.zhangsan20191126.presenter.Presenter;
import com.com.bawei.zhangsan20191126.view.MyGroup;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {
    private String str = "http://172.17.8.100/small/commodity/v1/findCommodityByKeyword?keyword=%E6%9D%BF%E9%9E%8B&page=1&count=5";
    private RecyclerView recyclerView;
    private MyAdapter myAdapter;
    private List<UserBean.ResultBean> list = new ArrayList<>();
    private Button button;
    private EditText edit;
    private MyGroup myGroup;


    @Override
    protected void getDing() {
        mPresenter.startRequest(str);
    }

    @Override
    protected BasePresenter getPresenter() {
        return new Presenter();
    }

    @Override
    protected void initView() {
        recyclerView = findViewById(R.id.rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        myAdapter = new MyAdapter(this, list);
        recyclerView.setAdapter(myAdapter);
        button = findViewById(R.id.button);
        edit = findViewById(R.id.edit);
        myGroup = findViewById(R.id.mg);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myGroup.addHat(edit.getText().toString().trim());
            }
        });
        //使用接口回调完成RecycleView点击事件，点击跳转到图2详情。
        myAdapter.setOnItemClick(new MyAdapter.onItemClick() {
            @Override
            public void onClick(int position) {
                Toast.makeText(MainActivity.this, "点击跳转", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, TwoActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    protected int layoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void onSuccess(String json) {
        Gson gson = new Gson();
        UserBean userBean = gson.fromJson(json, UserBean.class);
        list.addAll(userBean.getResult());
        //刷新
        myAdapter.notifyDataSetChanged();
    }

    @Override
    public void onError(String error) {

    }
}
