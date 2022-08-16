package com.Nie.service;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.xml.datatype.Duration;
import java.util.Random;
import java.util.concurrent.TimeUnit;

@Service
public class VerifyCodeServiceImpl implements VerifyCodeService {

    @Resource
    private RedisTemplate<String,String> redisTemplate;

    public String verifyCodeCreate() {
        Random random = new Random();
        String value = "";
        for (int i = 0; i < 6; i++) {
            value += random.nextInt(10);
        }
        return value;
    }

    public String insertVerifyCode(long timeOut) {
        String verifyCode = verifyCodeCreate();
        redisTemplate.opsForValue().set("verifyCode",verifyCode, timeOut ,TimeUnit.SECONDS);
        return verifyCode;
    }

    public String queryVerifyCode(String key) {
        return redisTemplate.opsForValue().get("verifyCode");
    }
}
