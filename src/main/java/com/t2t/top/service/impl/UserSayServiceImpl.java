package com.t2t.top.service.impl;

import com.t2t.top.dao.UserMapper;
import com.t2t.top.dao.UserSayMapper;
import com.t2t.top.exception.ServiceException;
import com.t2t.top.model.po.User;
import com.t2t.top.model.po.UserExample;
import com.t2t.top.model.po.UserSay;
import com.t2t.top.model.po.UserSayExample;
import com.t2t.top.service.UserSayService;
import com.t2t.top.util.GsonUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author yangpengfei
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class UserSayServiceImpl implements UserSayService {

    private static Logger logger = Logger.getLogger(UserSayServiceImpl.class);

    @Resource
    private UserSayMapper userSayMapper;

    public void add(UserSay say) throws ServiceException {
        try {
            logger.info("添加说说" + GsonUtils.toJson(say));
            if (say.getId() == null || say.getId() == 0) {
                say.setCreateTime(new Date());
                userSayMapper.insert(say);
            }
        } catch (Exception e) {
            throw new ServiceException(e);
        }
    }

    public void delete(UserSay say) throws ServiceException {
        userSayMapper.deleteByPrimaryKey(say.getId());
    }

    public List query(UserSay say) throws ServiceException {
        UserSayExample e = new UserSayExample();
        if (StringUtils.isNotEmpty(say.getSay())) {
            e.createCriteria().andSayLike(say.getSay());
        }
        return userSayMapper.selectByExample(e);
    }
}
