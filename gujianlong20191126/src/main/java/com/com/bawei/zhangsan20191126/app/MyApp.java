package com.com.bawei.zhangsan20191126.app;
/*
 *@auther:谷建龙
 *@Date: 2019/11/27
 *@Time:8:54
 *@Description:
 * */


import android.app.Application;
import android.content.Context;

public class MyApp extends Application {
    public static Context mContent;

    @Override
    public void onCreate() {
        super.onCreate();
        mContent = this;
    }
}
