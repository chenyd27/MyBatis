package com.cyd.mapper;

import com.cyd.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    List<User> getUserList();
    User getOneUser(int id);
    List<User> getUserListLimit(Map<String,Integer> map);
    List<User> getUserListRowBounds();
    @Select("select * from user where id = #{id} and name = #{name}")
    // Param注解可以限定参数名，同样适用于 xml
    User getOneUserplus(@Param("id") int id,@Param("name") String name); // @Param 基本类型参数要用，不然无法在注解中识别
    @Insert("insert into user(id,name,pwd) values(#{id},#{name},#{password})")
    void addUser(User user);
    @Delete("delete * from user where id = #{uid}")
    void deleteUser(@Param("uid") int id);
    @Update("update user set name = #{name}, pwd = #{password} where id = #{id}")
    void updateUser(User user);
}
