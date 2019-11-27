package com.com.bawei.zhangsan20191126.model;
/*
 *@auther:谷建龙
 *@Date: 2019/11/27
 *@Time:9:13
 *@Description:
 * */


import com.com.bawei.zhangsan20191126.contract.Contract;
import com.com.bawei.zhangsan20191126.utils.NetUtils;

public class Model implements Contract.IModel {
    @Override
    public void getInif(String url, final Contract.MyCallBack myCallBack) {
        NetUtils.getInstance().onDoGet(url, new NetUtils.MySuccess() {
            @Override
            public void onGet(String json) {
                myCallBack.onSuccess(json);
            }

            @Override
            public void onError(String error) {
                myCallBack.onError(error);
            }
        });
    }
}
