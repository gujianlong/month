package com.com.bawei.zhangsan20191126;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class TwoActivity extends AppCompatActivity {

    private WebView wv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);
        initView();
        WebSettings settings = wv.getSettings();
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        settings.setJavaScriptEnabled(true);
        wv.loadUrl("file:///C:/Users/l/Desktop/%E4%B8%93%E9%AB%984%E3%80%8AAndroid%E7%94%B5%E5%95%86%E9%A1%B9%E7%9B%AE%E5%AE%9E%E6%88%98%E3%80%8BA%E5%8D%B7/A%E5%8D%B7/%E7%B4%A0%E6%9D%90/info.html");
        wv.setWebViewClient(new WebViewClient() {
            @Override
            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                super.onReceivedError(view, errorCode, description, failingUrl);
            }
        });
        wv.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                super.onProgressChanged(view, newProgress);
            }
        });
    }

    private void initView() {
        wv = (WebView) findViewById(R.id.wv);
    }
}
