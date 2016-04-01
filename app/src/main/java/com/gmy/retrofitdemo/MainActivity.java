package com.gmy.retrofitdemo;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.webkit.WebView;
import android.widget.TextView;

import com.gmy.retrofitdemo.net.SupportService;
import com.gmy.retrofitdemo.net.model.NetEntity;
import com.gmy.retrofitdemo.net.model.NewsDetail;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "MainActivity";
    @Bind(R.id.webview)
    WebView webView;

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            try {
                webView.loadData(URLEncoder.encode(String.valueOf(msg.obj), "utf-8"), "text/html; charset=utf-8", null);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        new Thread() {
            @Override
            public void run() {
                try {
                    NetEntity entity = SupportService.init().getLatest().execute().body();
                    //SupportService.setBaseInfo(SupportService.BASE_URL);
                    NewsDetail newsDetail = SupportService.init().getDetail("3892357").execute().body();
                    //NetEntity entity = SupportService.getDetails().execute().body();
                    Log.e(TAG, entity.getDate() + " " + entity.getStories().get(0).getTitle());
                    Log.e(TAG, newsDetail.getBody());
                    Message message = new Message();
                    message.obj = newsDetail.getBody();
                    handler.sendMessage(message);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }.start();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}