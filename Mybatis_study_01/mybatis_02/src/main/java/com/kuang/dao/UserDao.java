package com.kuang.dao;

import com.kuang.pojo.User;

import java.util.List;

public interface UserDao { // dao == mapper
    List<User> getUserList();
}
