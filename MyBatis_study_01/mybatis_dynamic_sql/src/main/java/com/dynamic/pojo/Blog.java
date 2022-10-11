package com.dynamic.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class Blog {
    private String id;
    private String title;
    private String author;
    private Date createTime; // 需要开启驼峰命名映射
    private String views;
}
