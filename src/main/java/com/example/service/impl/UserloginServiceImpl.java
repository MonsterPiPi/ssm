package com.example.service.impl;

import com.example.dao.IUserloginDao;
import com.example.service.IUserloginService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by LiQian_Nice on 2018/2/19
 *
 * 维护用户登陆接口的实现类
 */
@Service("userloginService")
public class UserloginServiceImpl implements IUserloginService {

    @Resource
    private IUserloginDao userloginDao;
}
