package com.example.service.impl;

import com.example.bean.Course;
import com.example.dao.ICourseDao;
import com.example.service.ICourseService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by LiQian_Nice on 2018/2/19
 *
 * 维护课程信息接口的实现类
 */
@Service("courseService")
public class CourseServiceImpl implements ICourseService {

    @Resource
    private ICourseDao courseDao;

    @Override
    public List<Course> getAllCourse() {
        return courseDao.getAllCourse();
    }

    @Override
    public List<Course> getCoursesByName(String name) {
        return courseDao.getCoursesByName(name);
    }

    @Override
    public boolean deleteCourseById(String id) {
        try{
            courseDao.deleteCourseById(id);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
