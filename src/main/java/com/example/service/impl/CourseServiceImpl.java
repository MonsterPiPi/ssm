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
    public List<Course> findAll() {
        return courseDao.findAll();
    }

    @Override
    public List<Course> findAllByName(String name) {
        return courseDao.findAllByName(name);
    }

    @Override
    public void delete(String id) {
        try{
            courseDao.delete(id);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void add(Course course) {
        courseDao.add(course);
    }

    @Override
    public void update(Course course) {
        courseDao.update(course);
    }

    @Override
    public List<String> findSameSpecialtyCourses(String name) {
        return courseDao.findSameSpecialtyCourses(name);
    }
}
