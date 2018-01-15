package com.example.service.impl;

import com.example.dao.BlogDao;
import com.example.pojo.Blog;
import com.example.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User : 51103942@qq.com
 * Date : 2018/1/3
 * Time : 18:06
 * Talk is cheap. Show me the code.
 */
@Transactional
@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    public BlogDao blogDao;

    public void save(Blog blog) {
         blogDao.save(blog);
    }

    public List<Blog> findBlogs(String searchText) {
        return blogDao.findBlogs(searchText);
    }

    public List<Blog> findAll() {
        return blogDao.findAll();
    }

    public List<Blog> findAllCategories() {
        return blogDao.findAllCategories();
    }


}
