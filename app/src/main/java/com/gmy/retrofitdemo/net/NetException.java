package com.gmy.retrofitdemo.net;

/**
 * 网络异常
 * Created by gmy on 16/4/1.
 * E-mail me via gmyboy@qq.com
 */
public class NetException extends RuntimeException {
    private String code;

    public NetException(String detailMessage, String code) {
        super(detailMessage);
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    @Override
    public String toString() {
        String msg = getLocalizedMessage();
        String name = getClass().getName();
        if (msg == null) {
            return String.format("%s:%s", name, code);
        }
        return String.format("%s:[%s]%s", name, code, msg);
    }
}
