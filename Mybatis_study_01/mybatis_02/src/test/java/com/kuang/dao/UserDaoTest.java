package com.kuang.dao;

import com.kuang.pojo.User;
import com.kuang.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class UserDaoTest {
    @Test
    public void test(){
        // 获取sqlsession对象，读取对象中的数据库
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        try {
            // 方式一：getMapper
            // 执行sql
            UserMapper mapper = sqlSession.getMapper(UserMapper.class); // 通过userdao的class对象
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

}
