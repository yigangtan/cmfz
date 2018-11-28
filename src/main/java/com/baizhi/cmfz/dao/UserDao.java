package com.baizhi.cmfz.dao;

import com.baizhi.cmfz.entity.User;
import org.apache.ibatis.annotations.Param;


public interface UserDao {
    public User selectOne(@Param("username") String username, @Param("password") String password);
}
