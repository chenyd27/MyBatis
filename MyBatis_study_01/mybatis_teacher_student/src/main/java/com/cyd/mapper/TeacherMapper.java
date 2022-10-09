package com.cyd.mapper;

import com.cyd.pojo.Teacher;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
public interface TeacherMapper {
    // 获取所有老师信息
    public List<Teacher> getTeacherList();
    // 获取指定老师下的所有学生及老师的信息
    Teacher getTeacher(@Param("tid") int id);
    Teacher getTeacher2(@Param("tid") int id);

    @Select("select * from teacher where id = #{tid}")
    public Teacher getOneTeacher(@Param("tid") int id);
}
