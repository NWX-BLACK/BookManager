package com.Nie.service;

import com.Nie.dao.UserMapper;
import com.Nie.dao.UserMapperImpl;
import com.Nie.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserMapper userMapperImpl;

    @Resource
    private RedisTemplate redisTemplate;

    public List<User> queryAll() {
        return userMapperImpl.queryAll();
    }

    public User queryByUserId(int userId) {
        return userMapperImpl.queryByUserId(userId);
    }

    public User queryByUserName(String userName) {

        //采用Redis做一个缓存
        ValueOperations valueOperations = redisTemplate.opsForValue();
        User userByRedis = (User) valueOperations.get("User-"+userName+":");
        if(userByRedis == null){
            User userByMysql = userMapperImpl.queryByUserName(userName);
            valueOperations.set("User-"+userName+":",userByMysql);
            return userByMysql;
        }

        return userByRedis;
    }

    public int insertUser(User user) {

        return userMapperImpl.insertUser(user);
    }

    public int deleteUser(String userName) {

        //Redis缓存中也删除
        int num = userMapperImpl.deleteUser(userName);

        redisTemplate.delete("User-"+userName+":");
        return num;
    }

    public int updateUser(User user) {

        int num = userMapperImpl.updateUser(user);
        redisTemplate.delete("User-"+user.getUserName()+":");
        return num;
    }
}
