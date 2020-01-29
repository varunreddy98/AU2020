package com.accolite.au.web.xmldemo.dao;

import com.accolite.au.web.xmldemo.models.User;

import java.util.List;

public interface UserDao {

    User getUser(String tel);

    User setandGetUserservice(User user);

    void setUp();

    void addUserService(User user);

    List<User> getAll();
    void deleteUser(String tel);
}
