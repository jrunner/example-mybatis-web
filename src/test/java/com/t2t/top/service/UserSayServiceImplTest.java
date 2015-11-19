package com.t2t.top.service;

import com.t2t.top.BaseTest;
import com.t2t.top.model.po.User;
import com.t2t.top.model.po.UserSay;
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
public class UserSayServiceImplTest extends BaseTest {

    @Autowired
    public UserSayService userSayService;

    @Test
    public void test_add() {
        try {
            UserSay say = new UserSay();
            say.setCreateTime(new Date());
            say.setSay("程序猿要了3个孩子，分别取名叫Ctrl、Alt 和Delete，如果他们不听话，程序猿就只要同时敲他们一下就会好的!");
            userSayService.add(say);
        } catch (Exception e) {
            logger.info(e.getMessage());
        }
    }

    @Test
    public void test_query() {
        try {
            UserSay say = new UserSay();
            List list = userSayService.query(say);
            println(list);
        } catch (Exception e) {
            logger.info(e.getMessage());
        }
    }

}
