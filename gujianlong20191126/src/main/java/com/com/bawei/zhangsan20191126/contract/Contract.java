package com.com.bawei.zhangsan20191126.contract;
/*
 *@auther:谷建龙
 *@Date: 2019/11/27
 *@Time:9:10
 *@Description:
 * */

//定义契约类
public interface Contract {
    interface MyCallBack {
        void onSuccess(String json);

        void onError(String error);
    }

    interface IModel {
        void getInif(String url, MyCallBack myCallBack);
    }

    interface IView {
        void onSuccess(String json);

        void onError(String error);
    }

    interface IPresenter {
        void startRequest(String url);
    }
}
