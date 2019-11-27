package com.com.bawei.zhangsan20191126.base;
/*
 *@auther:谷建龙
 *@Date: 2019/11/27
 *@Time:9:18
 *@Description:
 * */


import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.com.bawei.zhangsan20191126.contract.Contract;

//封装BaseActivity类定义泛型初始化P层
public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity implements Contract.IView {
    public P mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (layoutId() != 0) {
            setContentView(layoutId());
            initView();
            mPresenter = getPresenter();
            if (mPresenter != null) {
                mPresenter.onAttchView(this);
            }
            getDing();
        }

    }

    protected abstract void getDing();

    protected abstract P getPresenter();

    protected abstract void initView();

    protected abstract int layoutId();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.onDeAttchView();
    }
}
