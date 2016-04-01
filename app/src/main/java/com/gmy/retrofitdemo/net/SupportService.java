package com.gmy.retrofitdemo.net;

import com.gmy.retrofitdemo.net.model.NetEntity;
import com.gmy.retrofitdemo.net.model.NewsDetail;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 支持的service
 * Created by gmy on 16/4/1.
 */
public class SupportService {
    public static String BASE_URL = "http://news-at.zhihu.com/";
    private static SupportService instance;

    private RestApi restApi;

    public static void setBaseInfo(String baseUrl) {
        if (baseUrl.endsWith("/")) {
            BASE_URL = baseUrl;
        } else {
            BASE_URL = String.format("%s/", baseUrl);
        }
    }

    /**
     * 双检测加锁，但是依旧无法完美解决并发问题
     *
     * @return
     */
    public static SupportService init() {
        if (instance == null) {
            synchronized (SupportService.class) {
                if (instance == null) {
                    instance = new SupportService();
                    if (instance.restApi == null) {
                        Retrofit retrofit = new Retrofit.Builder()
                                .baseUrl(BASE_URL)
                                .addConverterFactory(GsonConverterFactory.create())
                                .client(OkHttpClientFactory.getInstance().getOkHttpClient())
                                .build();
                        instance.restApi = retrofit.create(RestApi.class);
                    }
                }
            }
        }
        return instance;
    }

    public Call<NetEntity> getLatest() {
        return restApi.getLatest();
    }

    public Call<NewsDetail> getDetail(String nid) {
        return restApi.getDetail(nid);
    }

}
