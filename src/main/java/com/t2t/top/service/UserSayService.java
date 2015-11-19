package com.t2t.top.service;

import com.t2t.top.exception.ServiceException;
import com.t2t.top.model.po.UserSay;

import java.util.List;

/**
 * @author IluckySi
 * @since 20151014
 */
public interface UserSayService {
    public void add(UserSay say) throws ServiceException;

    public List query(UserSay say) throws ServiceException;

    public void delete(UserSay say) throws ServiceException;
}
