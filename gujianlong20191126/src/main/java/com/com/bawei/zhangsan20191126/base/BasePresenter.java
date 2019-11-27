package com.com.bawei.zhangsan20191126.base;
/*
 *@auther:谷建龙
 *@Date: 2019/11/27
 *@Time:9:14
 *@Description:
 * */

import com.com.bawei.zhangsan20191126.contract.Contract;

import java.lang.ref.WeakReference;

//封装BasePresenter类定义泛型
public abstract class BasePresenter<V extends Contract.IView> implements Contract.IPresenter {
    private WeakReference<V> mWeak;

    public BasePresenter() {
        initModel();
    }

    protected abstract void initModel();

    protected void onAttchView(V v) {
        mWeak = new WeakReference<>(v);
    }

    protected void onDeAttchView() {
        if (mWeak != null) {
            mWeak.clear();
            mWeak = null;
        }
    }

    protected V getView() {
        return mWeak.get();
    }
}
