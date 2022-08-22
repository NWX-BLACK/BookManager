package com.Nie.pojo;

import java.io.Serializable;
import java.sql.Date;

public class User implements Serializable {
   private Integer userId;
   private String userName;
   private String passWord;
   private Date lastLoginTime;

    public User() {
    }

    public User(Integer userId, String userName, String passWord, Date lastLoginTime) {
        this.userId = userId;
        this.userName = userName;
        this.passWord = passWord;
        this.lastLoginTime = lastLoginTime;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", passWord='" + passWord + '\'' +
                ", lastLoginTime=" + lastLoginTime +
                '}';
    }
}
