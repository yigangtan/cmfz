package com.baizhi.cmfz.service.impl;

import com.baizhi.cmfz.dao.UserDao;
import com.baizhi.cmfz.entity.User;
import com.baizhi.cmfz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public User login(String username, String password) {
        User user=userDao.selectOne(username,password);
        return user;
    }
}
