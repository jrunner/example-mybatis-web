package com.t2t.top.service;

import com.t2t.top.BaseTest;
import com.t2t.top.model.po.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;

/**
 * Created by yangpengfei on 2015/11/7.
 */
@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = {"/spring/spring-core.xml"})
@ContextConfiguration(locations = {"classpath:spring/spring-core.xml"})
public class UserServiceImplTest extends BaseTest {

    @Autowired
    public UserService userService;

    @Test
    public void test_add() {
        try {
            User user = new User();
            user.setBirthday(new Date());
            user.setName("杨鹏飞");
            user.setSex(true);
            user.setPassword("123456789");
            user.setUserType("管理员");
            userService.add(user);
        } catch (Exception e) {
            logger.info(e.getMessage());
        }
    }

    @Test
    public void test_query() {
        try {
            User user = new User();
            //user.setName("杨鹏飞");
            List list = userService.query(user);
            println(list);
        } catch (Exception e) {
            logger.info(e.getMessage());
        }
    }

}
