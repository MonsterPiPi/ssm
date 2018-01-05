package com.example.dao;

import com.example.pojo.Blog;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User : 51103942@qq.com
 * Date : 2018/1/3
 * Time : 18:05
 * Talk is cheap. Show me the code.
 */
public interface BlogDao {
    void save(Blog blog);

    List<Blog> findBlogs(String searchText);
}
