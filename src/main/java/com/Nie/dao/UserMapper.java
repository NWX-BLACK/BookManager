package com.Nie.dao;

import com.Nie.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    //1.查询全部用户
    List<User> queryAll();

    //2.通过id查询单个用户
    User queryByUserId(@Param("userId") int userId);

    //3.根据用户名查询用户
    User queryByUserName(@Param("userName") String userName);

    //4.增加一个用户（不可重复）
    int insertUser(@Param("user") User user);

    //5. 根据用户名删除一个用户
    int deleteUser(@Param("userName") String userName);

    //6.更新用户信息（密码）
    int updateUser(@Param("user") User user);

}
