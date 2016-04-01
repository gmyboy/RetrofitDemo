package com.gmy.retrofitdemo.net;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 请求参数构造器
 * Created by gmy on 16/4/1.
 * E-mail me via gmyboy@qq.com
 */
public class ParamsBuilder {
    private HashMap<String, String> params = new HashMap<>();

    <T> void addParam(String key, T value) {
        params.put(key, String.valueOf(value));
    }

    HashMap<String, String> buildMap() {
        return params;
    }

    String getParams() {
        Map<String, String> params = buildMap();
        Set<Map.Entry<String, String>> setParams = params.entrySet();
        StringBuilder str_params = new StringBuilder();
        for (Map.Entry<String, String> param : setParams) {
            try {
                str_params.append(param.getKey()).append("=").append(URLEncoder.encode(param.getValue(), "UTF-8")).append("&");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return str_params.toString();
    }
}
