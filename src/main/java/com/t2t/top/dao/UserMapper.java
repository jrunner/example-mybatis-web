package com.t2t.top.dao;

import com.t2t.top.model.po.UserExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper<User> extends BaseMapper {
    int countByExample(UserExample example);

    int deleteByExample(UserExample example);

    List<User> selectByExample(UserExample example);

    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    int updateByExample(@Param("record") User record, @Param("example") UserExample example);
}