package com.t2t.top.controller;

import com.t2t.top.BaseTest;
import com.t2t.top.model.po.User;
import com.t2t.top.util.BeanUtils;
import com.t2t.top.util.RestUtils;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yangpengfei on 2015/11/6.
 */
public class UserControllerTest extends BaseTest {
    String url = "http://localhost:8080/example-mybatis-web";

    @Test
    public void test_query() {
        Map param = new HashMap();
        param.put("name", "杨鹏飞");
        Object json = RestUtils.post(url + "/say/query", param);
        System.out.println(json);
    }

    @Test
    public void test_add() {
        try {
            User user = new User();
            user.setName("杨鹏飞");
            user.setSex(true);
            user.setPassword("123456789");
            user.setUserType("管理员");
            Map param = BeanUtils.objectToMap(user);
            param.put("birthday","2015-10-10");
            Object json = RestUtils.post(url + "/say/add", param);
            System.out.println(json);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
