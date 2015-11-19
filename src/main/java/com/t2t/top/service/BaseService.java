package com.t2t.top.service;

import com.t2t.top.exception.ServiceException;
import com.t2t.top.model.BaseModel;

import java.util.List;

/**
 * Created by yangpengfei on 2015/11/3.
 */
public interface BaseService {
    public void add(BaseModel model) throws ServiceException;

    public void update(BaseModel model) throws ServiceException;

    public void delete(BaseModel model) throws ServiceException;

    public BaseModel get(Class<BaseModel> cls, String id) throws ServiceException;

    public List<BaseModel> query(BaseModel model) throws ServiceException;
}
