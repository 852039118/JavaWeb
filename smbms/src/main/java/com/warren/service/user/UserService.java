package com.warren.service.user;

import com.warren.pojo.User;

import java.util.List;

public interface UserService {
    //用户登录
    public User login(String userCode, String password);

    //修改当前用户密码 : 根据ID
    public boolean updatePwd(int id, String pwd);

    //根据用户名或者角色查询用户总数
    public int getUserCount(String userName, int userRole);

    //根据条件查询用户列表
    public List<User> getUserList(String queryUserName, int queryUserRole, int currentPageNo, int pageSize);
}
