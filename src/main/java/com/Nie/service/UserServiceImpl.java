package com.Nie.service;

import com.Nie.dao.UserMapper;
import com.Nie.dao.UserMapperImpl;
import com.Nie.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserMapper userMapperImpl;

    public List<User> queryAll() {
        return userMapperImpl.queryAll();
    }

    public User queryByUserId(int userId) {
        return userMapperImpl.queryByUserId(userId);
    }

    public User queryByUserName(String userName) {
        return userMapperImpl.queryByUserName(userName);
    }

    public int insertUser(User user) {
        return userMapperImpl.insertUser(user);
    }

    public int deleteUser(String userName) {
        return userMapperImpl.deleteUser(userName);
    }

    public int updateUser(User user) {
        return userMapperImpl.updateUser(user);
    }
}
