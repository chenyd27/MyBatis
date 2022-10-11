package com.dynamic.mapper;

import com.dynamic.pojo.Blog;
import com.dynamic.utils.IDUtils;
import com.dynamic.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.*;

public class BlogTest {
    //@Test
    public void getInsert(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper blogMapper = sqlSession.getMapper(BlogMapper.class);

        Blog blog2 = new Blog();
        blog2.setId(IDUtils.getId());
        blog2.setTitle("Hallo PA");
        blog2.setAuthor("cqs");
        blog2.setCreateTime(new Date());
        blog2.setViews("9997");
        blogMapper.addBook(blog2);
        sqlSession.close();
    }
    @Test
    public void getBlogListIF(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper blogMapper = sqlSession.getMapper(BlogMapper.class);
        HashMap map = new HashMap<>();
        // map.put("title","Hallo world");
        List<Blog> arr = blogMapper.queryBlogIF(map);
        for(Blog b : arr){
            System.out.println(b);
        }
        sqlSession.close();

        System.out.println("-------------------");
        SqlSession sqlSession2 = MybatisUtils.getSqlSession();
        BlogMapper blogMapper2 = sqlSession2.getMapper(BlogMapper.class);
        HashMap map2 = new HashMap<>();
        List<Blog> arr1 = blogMapper2.queryBlogIF(map2);
        for(Blog b : arr1){
            System.out.println(b);
        }
        sqlSession2.close();
    }
    // @Test
    public void queryBlogForeach(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper blogMapper = sqlSession.getMapper(BlogMapper.class);
        HashMap map = new HashMap<>();
        List<String> ids = new ArrayList<>();
        ids.add("90ae5e99fa79467986993b92abcfe7c0");
        ids.add("e5c11ff6c45f4c2e97139afbac5f1790");
        map.put("ids",ids);
        blogMapper.queryBlogForeach(map);
        sqlSession.close();
    }
}
