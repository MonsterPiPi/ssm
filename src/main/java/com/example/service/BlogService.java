package com.example.service;

import com.example.pojo.Blog;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User : 51103942@qq.com
 * Date : 2018/1/3
 * Time : 18:06
 * Talk is cheap. Show me the code.
 */
public interface BlogService {

    void save(Blog blog);

    List<Blog> findBlogs(String searchText);

    List<Blog> findAll();


    List<Blog> findAllCategories();
}
