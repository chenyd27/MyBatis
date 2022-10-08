package com.cyd.mapper;

import com.cyd.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    List<User> getUserList();
    User getOneUser(int id);
    List<User> getUserListLimit(Map<String,Integer> map);
    List<User> getUserListRowBounds();

}
