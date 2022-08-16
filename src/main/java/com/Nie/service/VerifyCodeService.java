package com.Nie.service;

public interface VerifyCodeService {

    //生成6位验证码
     String verifyCodeCreate();

    //将验证码插入redis
     String insertVerifyCode(long timeOut);

    //将验证码从redis取出
    String queryVerifyCode(String key);
}
