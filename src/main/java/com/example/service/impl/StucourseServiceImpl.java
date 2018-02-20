package com.example.service.impl;

import com.example.dao.IStucourseDao;
import com.example.service.IStucourseService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by LiQian_Nice on 2018/2/19
 *
 * 维护学生课程信息接口的实现类
 */
@Service("stucourseService")
public class StucourseServiceImpl implements IStucourseService {

    @Resource
    private IStucourseDao stucourseDao;
}
