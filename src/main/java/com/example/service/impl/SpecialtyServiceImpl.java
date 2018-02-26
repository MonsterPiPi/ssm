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
    public List<Specialty> getAllSpecialty() {
        return specialtyDao.getAllSpecialty();
    }

    @Override
    public void addSpecialty(Specialty specialty) {
        specialtyDao.addSpecialty(specialty);
    }
}
