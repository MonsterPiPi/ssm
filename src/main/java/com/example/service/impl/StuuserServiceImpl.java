package com.example.service.impl;

import com.example.bean.Stuuser;
import com.example.dao.IStuuserDao;
import com.example.service.IStuuserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by LiQian_Nice on 2018/2/17
 *
 * 维护学生相关信息的实现类
 */
@Service("stuuserService")
public class StuuserServiceImpl implements IStuuserService{

    @Resource
    private IStuuserDao iStuuserDao;

    @Override
    public boolean addStuuser(Stuuser stuuser) {
        return iStuuserDao.addStuuser(stuuser);
    }
}
