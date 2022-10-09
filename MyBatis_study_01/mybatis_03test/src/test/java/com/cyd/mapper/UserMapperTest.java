package com.cyd.mapper;

import com.cyd.pojo.User;
import com.cyd.utils.MybatisUtils;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserMapperTest {
    static Logger logger = Logger.getLogger(UserMapperTest.class);
    @Test
    public void getUserTest(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> arr = userMapper.getUserList();
        for(User user : arr){
            System.out.println(user.getName());
        }
        sqlSession.close();
    }
    @Test
    public void getUserOneTest(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.getOneUser(2);
        System.out.println(user.getPassword());
        sqlSession.close();
    }
@Test
    public void getLimit(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        Map<String,Integer> map = new HashMap<>();
        map.put("startIndex",1);
        map.put("pageSize",3);
        List<User> arr = userMapper.getUserListLimit(map);
        for(User user: arr){
            System.out.println(user.getId() + '\t' + user.getName() + '\t' + user.getPassword());
        }
        sqlSession.close();
    }
    @Test
    public void getUserOneTest1(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = new User(5,"cyd","15919173221");
        userMapper.addUser(user);
        sqlSession.close();
    }
}
