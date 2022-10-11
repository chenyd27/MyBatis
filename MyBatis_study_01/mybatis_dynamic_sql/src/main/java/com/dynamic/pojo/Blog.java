package com.dynamic.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class Blog implements Serializable {
    private String id;
    private String title;
    private String author;
    private Date createTime; // 需要开启驼峰命名映射
    private String views;
}
