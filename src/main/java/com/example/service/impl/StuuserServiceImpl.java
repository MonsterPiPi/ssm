package com.example.service.impl;

import com.example.bean.Stuuser;
import com.example.dao.IStuuserDao;
import com.example.service.IStuuserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by LiQian_Nice on 2018/2/17
 *
 * 维护学生相关信息的实现类
 */
@Service("stuuserService")
public class StuuserServiceImpl implements IStuuserService{

    @Resource
    private IStuuserDao stuuserDao;

    @Override
    public void addStuuser(Stuuser stuuser) {
         stuuserDao.addStuuser(stuuser);
    }

    @Override
    public List<String> findSameSpecialtyStuuser(String name) {
        return stuuserDao.findSameSpecialtyStuuser(name);
    }
}
