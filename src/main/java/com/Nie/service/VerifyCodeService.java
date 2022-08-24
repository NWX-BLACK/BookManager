package com.Nie.service;

public interface VerifyCodeService {


    //将验证码插入redis
     String insertVerifyCode(long timeOut);

    //将验证码从redis取出
    String queryVerifyCode(String key);
}
