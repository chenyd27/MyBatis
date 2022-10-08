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
        System.out.println(user.getPwd());
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
            System.out.println(user.getId() + '\t' + user.getName() + '\t' + user.getPwd());
        }
        sqlSession.close();
    }
    @Test
    public void getRowBounds(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        // rowbounds 实现
        RowBounds rowBounds = new RowBounds(1,2);
        // 通过java 代码实现分页
        List<User> arr = sqlSession.selectList("com.cyd.mapper.UserMapper.getUserListRowBounds",null,rowBounds);
        for(User user: arr){
            System.out.println(user.getId() + '\t' + user.getName() + '\t' + user.getPwd());
        }
        sqlSession.close();
    }
}
