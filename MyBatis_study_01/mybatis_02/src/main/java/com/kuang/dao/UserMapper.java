package com.kuang.dao;

import com.kuang.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserMapper { // dao == mapper
    List<User> getUserList();// 获取全部用户
    User getSingleUser(int id); // 获取单个用户
    void addUser(User user); // 插入单个用户
    void updateUser(User user); // 修改
    void deleteUser(int id); // 删除,通过id删除

    void addUser2(Map<String, Object> map); // 万能的map，不用知道里面到底有没有数据
    List<User> getUserLike(String value);
}
