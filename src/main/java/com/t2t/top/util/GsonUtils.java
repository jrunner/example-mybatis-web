package com.t2t.top.util;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

/**
 * Created by yangpengfei on 2015/11/14.
 */
public class GsonUtils {

    public static String toJson(Object src) {
        Gson gson = new Gson();
        return gson.toJson(src);
    }

    public <T> T fromJson(String json, Class<T> classOfT) throws JsonSyntaxException {
        Gson gson = new Gson();
        return gson.fromJson(json, classOfT);
    }
}
