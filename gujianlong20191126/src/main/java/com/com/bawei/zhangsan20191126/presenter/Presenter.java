package com.com.bawei.zhangsan20191126.presenter;
/*
 *@auther:谷建龙
 *@Date: 2019/11/27
 *@Time:9:29
 *@Description:
 * */


import com.com.bawei.zhangsan20191126.base.BasePresenter;
import com.com.bawei.zhangsan20191126.contract.Contract;
import com.com.bawei.zhangsan20191126.model.Model;

public class Presenter extends BasePresenter {
    private Contract.IModel iModel;

    @Override
    protected void initModel() {
        iModel = new Model();
    }

    @Override
    public void startRequest(String url) {
        iModel.getInif(url, new Contract.MyCallBack() {
            @Override
            public void onSuccess(String json) {
                getView().onSuccess(json);
            }

            @Override
            public void onError(String error) {
                getView().onError(error);
            }
        });
    }
}
