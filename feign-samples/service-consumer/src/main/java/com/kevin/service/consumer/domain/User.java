package com.kevin.service.consumer.domain;

import java.io.Serializable;

/**
 * 用户信息
 *
 * @author wangyong
 */
public class User implements Serializable {

    /**
     * 用户名,描述
     */
    private String userName, desc;


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public User(String userName, String desc) {
        this.userName = userName;
        this.desc = desc;
    }

    public User() {
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("UserDO{");
        sb.append("userName='").append(userName).append('\'');
        sb.append(", desc='").append(desc).append('\'');
        sb.append('}');
        return sb.toString();
    }


}
