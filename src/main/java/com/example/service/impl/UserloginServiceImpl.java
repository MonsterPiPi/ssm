package com.example.service.impl;

import com.example.bean.Userlogin;
import com.example.dao.IUserloginDao;
import com.example.service.IUserloginService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by LiQian_Nice on 2018/2/19
 *
 * 维护用户登陆接口的实现类
 */
@Service("userloginService")
public class UserloginServiceImpl implements IUserloginService {

    @Resource
    private IUserloginDao userloginDao;

    @Override
    public List<Userlogin> findAll() {
        return userloginDao.findAll();
    }

    @Override
    public void add(Userlogin userlogin) {
         userloginDao.add(userlogin);
    }

    @Override
    public Userlogin findById(String id) {
        return userloginDao.findById(id);
    }

    @Override
    public void delete(String id) {
        userloginDao.delete(id);
    }

    @Override
    public List<Userlogin> getAllByType(String type) {
        return userloginDao.getAllByType(type);
    }

    @Override
    public String getTypeById(String id) {
        return userloginDao.getTypeById(id);
    }

    @Override
    public void update(Userlogin userlogin) {
        userloginDao.update(userlogin);
    }
}
