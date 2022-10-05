package com.kuang.dao;

import com.kuang.pojo.User;
import com.kuang.utils.MybatisUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

public class UserDaoTest {
    @Test
    public void test(){
        // 获取sqlsession对象，读取对象中的数据库
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        try {
            // 方式一：getMapper
            // 执行sql
            UserDao mapper = sqlSession.getMapper(UserDao.class); // 通过userdao的class对象
            List<User> userList= mapper.getUserList(); // 方法，获取对象


            for(User user : userList){
                System.out.println(user.getName() + "\t" + user.getPwd());
            }
        } catch (Exception e){
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }

        // 关闭sqlSession
        sqlSession.close();
    }
    @Test
    public void getUserById(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class); // 获取对象接口
        User user = userDao.getSingleUser(1);
        System.out.println(user.getName());
        sqlSession.close();
    }
    // 增删改查需要提交事务
    @Test
    public void addUser1(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        User user1 = new User(1,"jjm","18011784568");
        userDao.addUser(user1);
        // 提交事务
        sqlSession.commit(); // 重点，提交事务
        sqlSession.close();
    }
    @Test
    public void update(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        userDao.updateUser(new User(5,"cq","13902227308"));
        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void delete(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        userDao.deleteUser(6);
        sqlSession.commit();
        sqlSession.close();
    }
}
