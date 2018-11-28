package com.baizhi.cmfz.service;


import com.baizhi.cmfz.entity.User;

public interface UserService {
    public User login(String username,String password);
}
