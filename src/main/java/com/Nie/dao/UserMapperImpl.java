package com.Nie.dao;

import com.Nie.pojo.User;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserMapperImpl implements UserMapper{
    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate = sqlSessionTemplate;
    }

    public List<User> queryAll() {
        UserMapper mapper = sqlSessionTemplate.getMapper(UserMapper.class);
        return mapper.queryAll();
    }

    public User queryByUserId(int userId) {
        UserMapper mapper = sqlSessionTemplate.getMapper(UserMapper.class);
        return mapper.queryByUserId(userId);
    }

    public User queryByUserName(String userName) {
        UserMapper mapper = sqlSessionTemplate.getMapper(UserMapper.class);
        return mapper.queryByUserName(userName);
    }

    public int insertUser(User user) {
        UserMapper mapper = sqlSessionTemplate.getMapper(UserMapper.class);
        return mapper.insertUser(user);
    }

    public int deleteUser(String userName) {
        UserMapper mapper = sqlSessionTemplate.getMapper(UserMapper.class);
        return mapper.deleteUser(userName);
    }

    public int updateUser(User user) {
        UserMapper mapper = sqlSessionTemplate.getMapper(UserMapper.class);
        return mapper.updateUser(user);
    }
}
