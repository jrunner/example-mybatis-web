package com.t2t.top.service;

import com.t2t.top.exception.ServiceException;
import com.t2t.top.model.po.User;

import java.util.List;

/**
 * @author yangpengfei
 */
public interface UserService {

    public void add(User user) throws ServiceException;

    public List query(User user) throws ServiceException;

    public void delete(User user) throws ServiceException;
}
