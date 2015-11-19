package com.t2t.top.dao;


import java.util.List;

import com.t2t.top.model.po.UserSay;
import com.t2t.top.model.po.UserSayExample;
import org.apache.ibatis.annotations.Param;

public interface UserSayMapper {
    int countByExample(UserSayExample example);

    int deleteByExample(UserSayExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UserSay record);

    int insertSelective(UserSay record);

    List<UserSay> selectByExample(UserSayExample example);

    UserSay selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UserSay record, @Param("example") UserSayExample example);

    int updateByExample(@Param("record") UserSay record, @Param("example") UserSayExample example);

    int updateByPrimaryKeySelective(UserSay record);

    int updateByPrimaryKey(UserSay record);
}