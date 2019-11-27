package com.com.bawei.zhangsan20191126.view;
/*
 *@auther:谷建龙
 *@Date: 2019/11/27
 *@Time:9:55
 *@Description:
 * */


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MyGroup extends ViewGroup {
    private Context context;

    public MyGroup(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int childCount = getChildCount();
        //定义总数
        int prace = 10;
        //定义上下左右
        int left = 0;
        int right = 0;
        int top = 0;
        int button = 0;
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            childAt.measure(0, 0);
            int measuredWidth = childAt.getMeasuredWidth();
            int measuredHeight = childAt.getMeasuredHeight();
            left = right + prace;
            right = left + measuredWidth;
            int width = getWidth();
            //判断如果大于屏幕的宽度就换行
            if (right > width) {
                left = prace;
                top = prace + button;
            }
            right = left + measuredWidth;
            button = top + measuredHeight;
            childAt.layout(left, top, right, button);
        }

    }

    public void addHat(String content) {
        TextView textView = new TextView(context);
        textView.setGravity(Gravity.CENTER);
        textView.setTextSize(30);
        textView.setTextColor(Color.BLUE);
        textView.setText(content);
        addView(textView);
    }
}
