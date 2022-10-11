package com.dynamic.mapper;

import com.dynamic.pojo.Blog;

import java.util.List;
import java.util.Map;

public interface BlogMapper {
    // 插入数据
    int addBook(Blog blog);
    // 查询博客
    List<Blog> queryBlogIF(Map map);
    // 查询choose
    List<Blog> queryBlogChoose(Map map);
    // 更新博客
    int updateBlog(Map map);
    // 查询第1，2个记录的博客
    List<Blog> queryBlogForeach(Map map);
}
