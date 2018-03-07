package com.example.service.impl;

import com.example.bean.Specialty;
import com.example.dao.ISpecialtyDao;
import com.example.service.ISpecialtyService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by LiQian_Nice on 2018/2/19
 *
 * 维护专业信息接口的实现类
 */
@Service("specialtyService")
public class SpecialtyServiceImpl implements ISpecialtyService {

    @Resource
    private ISpecialtyDao specialtyDao;


    @Override
    public List<Specialty> findAll() {
        return specialtyDao.findAll();
    }

    @Override
    public List<Specialty> findAllByName(String name) {
        return specialtyDao.findAllByName(name);
    }

    @Override
    public void add(Specialty specialty) {
        specialtyDao.add(specialty);
    }

    @Override
    public void delete(String id) {
        specialtyDao.delete(id);
    }

    @Override
    public void update(Specialty specialty) {
        specialtyDao.update(specialty);
    }
}
