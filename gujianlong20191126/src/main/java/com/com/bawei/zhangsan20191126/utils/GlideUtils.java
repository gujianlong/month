package com.com.bawei.zhangsan20191126.utils;
/*
 *@auther:谷建龙
 *@Date: 2019/11/27
 *@Time:9:07
 *@Description:
 * */


import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;
import com.com.bawei.zhangsan20191126.R;
import com.com.bawei.zhangsan20191126.app.MyApp;
//④　使用Glide完成图片加载，并配置站位图、错误图。
public class GlideUtils {
    public static void loadImage(String url, ImageView imageView) {
        Glide.with(MyApp.mContent)
                .load(url)
                .placeholder(R.mipmap.ic_launcher)
                .priority(Priority.HIGH)
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .apply(RequestOptions.bitmapTransform(new CircleCrop()))
                .error(R.mipmap.ic_launcher)
                .into(imageView);
    }
}
