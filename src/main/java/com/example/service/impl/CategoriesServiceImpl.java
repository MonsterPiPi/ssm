package com.example.service.impl;

import com.example.dao.CategoriesDao;
import com.example.pojo.Categories;
import com.example.service.CategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User : 51103942@qq.com
 * Date : 2018/1/3
 * Time : 21:19
 * Talk is cheap. Show me the code.
 */
@Service
@Transactional
public class CategoriesServiceImpl implements CategoriesService {

    @Autowired
    public CategoriesDao categoriesDao;

    public void save(Categories categories) {
        categoriesDao.save(categories);
    }

    public List<Categories> findAll() {
        return categoriesDao.findAll();
    }
}
