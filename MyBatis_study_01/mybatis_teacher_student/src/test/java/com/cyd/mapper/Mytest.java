package com.cyd.mapper;

import com.cyd.pojo.Student;
import com.cyd.pojo.Teacher;
import com.cyd.utils.UserMapperUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class Mytest {
    @Test
    public void getTeacher(){
        SqlSession sqlSession = UserMapperUtils.getSqlSession();
        TeacherMapper teacherMapper = sqlSession.getMapper(TeacherMapper.class);
        Teacher arr = teacherMapper.getTeacher2(1);
        for(Student s : arr.getStudents()){
            System.out.println(s);
        }
        sqlSession.close();
    }
}
