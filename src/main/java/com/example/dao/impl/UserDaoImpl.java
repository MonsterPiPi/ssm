package com.example.dao.impl;

import com.example.dao.UserDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * Created by IntelliJ IDEA.
 * User : 51103942@qq.com
 * Date : 2018/1/2
 * Time : 8:28
 * Talk is cheap. Show me the code.
 */
@Repository
public class UserDaoImpl implements UserDao {

    @Resource
    private SessionFactory sessionFactory;

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }
}
