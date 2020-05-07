package com.warren.dao;

import com.warren.pojo.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    User queryUserById(@Param("id") int id);
}
