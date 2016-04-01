package com.gmy.retrofitdemo.net;

import com.gmy.retrofitdemo.net.model.NetEntity;
import com.gmy.retrofitdemo.net.model.NewsDetail;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * api注解
 * Created by gmy on 16/4/1.
 */
public interface RestApi {
    @GET("api/4/news/latest")
    Call<NetEntity> getLatest();

    @GET("api/4/news/{nid}")
    Call<NewsDetail> getDetail(@Path("nid") String nid);
}
