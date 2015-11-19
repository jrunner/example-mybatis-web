package com.t2t.top.service.impl;

import com.t2t.top.dao.UserMapper;
import com.t2t.top.exception.ServiceException;
import com.t2t.top.model.po.User;
import com.t2t.top.model.po.UserExample;
import com.t2t.top.service.UserService;
import com.t2t.top.util.GsonUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author yangpengfei
 */
@Service
@Transactional(rollbackFor = Exception.class)
class UserServiceImpl implements UserService {

    private static Logger logger = Logger.getLogger(UserServiceImpl.class);

    @Resource
    private UserMapper userMapper;

    public void add(User user) throws ServiceException {
        try {
            logger.info("添加用户" + GsonUtils.toJson(user));
            if (user.getId() == null || user.getId() == 0) {
                UserExample e = new UserExample();
                e.createCriteria().andNameEqualTo(user.getName());

                int count = userMapper.countByExample(e);
                if (count > 0) {
                    throw new ServiceException("用户名已存在!");
                }
                if (StringUtils.isEmpty(user.getUserType())) {
                    user.setUserType("普通用户");
                }
                user.setCreateTime(new Date());
                userMapper.insert(user);
            }
        } catch (Exception e) {
            throw new ServiceException(e);
        }
    }

    public void delete(User user) throws ServiceException {
        logger.info("删除用户" + GsonUtils.toJson(user));
        User u = (User) userMapper.selectByPrimaryKey(user.getId());
        if (u == null) {
            throw new ServiceException("该记录不存在!");
        }
        userMapper.deleteByPrimaryKey(user.getId());
    }

    public List query(User user) throws ServiceException {
        UserExample e = new UserExample();
        if (StringUtils.isNotEmpty(user.getName())) {
            e.createCriteria().andNameLike(user.getName());
        }
        return userMapper.selectByExample(e);
    }

}
