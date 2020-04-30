package com.warren.dao;

import com.warren.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserDao {
    //查询全部用户
    List<User> getUserList();

    //根据ID查询用户
    User getUserById(int id);

    //根据名称模糊查询用户
    List<User> getUserLike(String name);

    //insert用户
    int addUser(User user);

    //update用户
    int updateUser(User user);

    //万能的map
    int updateUser2(Map<String, Object> map);


    //delete用户
    int deleteUser(int id);
}
