package com.t2t.top.model.po;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.t2t.top.model.BaseModel;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class UserSay extends BaseModel {
    private Integer id;

    private String userid;

    private String say;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public String getSay() {
        return say;
    }

    public void setSay(String say) {
        this.say = say == null ? null : say.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}