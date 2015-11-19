package com.t2t.top.service.impl;

import com.t2t.top.exception.ServiceException;
import com.t2t.top.model.BaseModel;
import com.t2t.top.service.BaseService;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author yangpengfei
 */
@Service(value = "baseService")//没有指定value的话，默认是第一个字母小写的类名,可以看做是xml中的bean的id
@Lazy(value = true)//延迟初始化，防止自身实例化时，调用构造BaseServiceImpl方法出现object类型转换异常
public class BaseServiceImpl implements BaseService {

    public void add(BaseModel model) throws ServiceException {
    }

    public void update(BaseModel model) throws ServiceException {
    }

    public void delete(BaseModel model) throws ServiceException {
    }

    public BaseModel get(Class<BaseModel> cls, String id) throws ServiceException {
        return null;
    }

    public List<BaseModel> query(BaseModel model) throws ServiceException {
        return null;
    }
}
