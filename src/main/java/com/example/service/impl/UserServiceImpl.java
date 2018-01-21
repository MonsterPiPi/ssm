package com.example.service.impl;

import com.example.dao.UserDao;
import com.example.pojo.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User : 51103942@qq.com
 * Date : 2018/1/2
 * Time : 8:26
 * Talk is cheap. Show me the code.
 */
@Transactional
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    public UserDao userDao;

    public boolean save(User user) {

        return userDao.save(user);
    }

    public User findByEmailAndPassword(String email, String password) {
        return userDao.findByEmailAndPassword(email,password);
    }

    public User findByEmail(String email) {
        return userDao.findByEmail(email);
    }




}
