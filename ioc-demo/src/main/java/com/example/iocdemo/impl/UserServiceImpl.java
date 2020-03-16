package com.example.iocdemo.impl;

import com.example.iocdemo.service.UserService;

public class UserServiceImpl implements UserService {
    private String userName;
    @Override
    public void findAll() {
        System.out.println("findAll()被执行。。。"+userName);

    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
