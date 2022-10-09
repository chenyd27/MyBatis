package com.cyd.pojo;

import lombok.Data;

@Data
public class Student {
    private int id;
    private String name;
    // 学生需要关联老师
    private int tid;
    private Teacher teacher;
}
