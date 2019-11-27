package com.com.bawei.zhangsan20191126.utils;
/*
 *@auther:谷建龙
 *@Date: 2019/11/27
 *@Time:8:56
 *@Description:
 * */


import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.com.bawei.zhangsan20191126.app.MyApp;

import java.util.Map;

public class NetUtils {
    private final RequestQueue requestQueue;
    //封装基类

    private NetUtils() {
        requestQueue = Volley.newRequestQueue(MyApp.mContent);
    }

    private static class net {
        private static NetUtils netUtils = new NetUtils();
    }

    public static NetUtils getInstance() {
        return net.netUtils;
    }

    //定义接口
    public interface MySuccess {
        void onGet(String json);

        void onError(String error);
    }

    //封装Volley的get
    public void onDoGet(String url, final MySuccess mySuccess) {
        StringRequest request = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                mySuccess.onGet(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                mySuccess.onError(error.getMessage());
            }
        });
        requestQueue.add(request);
    }

    //封装Volley的post
    public void onDoPost(String url, final Map<String, String> map, final MySuccess mySuccess) {
        StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                mySuccess.onGet(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                mySuccess.onError(error.getMessage());
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                if (map != null) {
                    return map;
                }
                return super.getParams();
            }
        };
        requestQueue.add(request);
    }

    //封装网络状态判断方法，可以判断有网无网
    public boolean hasNet(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
            return true;
        } else {
            return false;
        }
    }
}
