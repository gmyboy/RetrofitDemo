package com.gmy.retrofitdemo.net;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.FormBody;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * OkFactory
 * Created by gmy on 16/4/1.
 * E-mail me via gmyboy@qq.com
 */
public class OkHttpClientFactory {
    public static final OkHttpClientFactory instance = new OkHttpClientFactory();
    private OkHttpClient okHttpClient;
    private OkHttpClient okHttpClientLongTime;
    private boolean isShowUrl = true;

    public static OkHttpClientFactory getInstance() {
        return instance;
    }

    private OkHttpClientFactory() {
        Interceptor interceptor = new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();
                if (isShowUrl) {
                    RequestBody requestBody = request.body();
                    StringBuilder stringBuilder = new StringBuilder(request.url().toString());
                    if (requestBody instanceof FormBody) {
                        FormBody formBody = (FormBody) requestBody;
                        stringBuilder.append("?");
                        for (int i = 0; i < formBody.size(); i++) {
                            stringBuilder.append(formBody.name(i));
                            stringBuilder.append("=");
                            stringBuilder.append(formBody.value(i));
                            stringBuilder.append("&");
                        }
                    }
                    NetLog.d(stringBuilder.toString());
                }
                return chain.proceed(request);
            }
        };
        //初始化一般okhttp
        OkHttpClient.Builder okHttpBuilder = new OkHttpClient.Builder();
        okHttpBuilder.addInterceptor(interceptor);
        okHttpClient = okHttpBuilder.build();

        //初始化超时okhttp
        OkHttpClient.Builder okHttpLongBuilder = new OkHttpClient.Builder();
        okHttpLongBuilder
                .connectTimeout(30, TimeUnit.SECONDS)
                .readTimeout(5, TimeUnit.MINUTES)
                .writeTimeout(5, TimeUnit.MINUTES)
                .addInterceptor(interceptor);
        okHttpClientLongTime = okHttpLongBuilder.build();
    }

    public OkHttpClient getOkHttpClient() {
        return okHttpClient;
    }

    public Response executeLongTime(Request request) throws IOException {
        return okHttpClientLongTime.newCall(request).execute();
    }
}
