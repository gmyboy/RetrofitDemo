package com.gmy.retrofitdemo.net;

/**
 * Created by gmy on 16/4/1.
 * E-mail me via gmyboy@qq.com
 */
public interface NetRespCode {
    String SUCCESS = "ok";
    String FAILED = "failed";
    int ERROR_UNKNOWN_HOST = -9996;
    int ERROR_CODE_4XX = -9997;
    int ERROR_CODE_5XX = -9998;
    int ERROR_OTHER = -9999;
}
