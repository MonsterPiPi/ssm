package com.example.service;

import com.example.bean.Course;

import java.util.List;

/**
 * Created by LiQian_Nice on 2018/2/19
 *
 * 维护课程相关的接口
 */
public interface ICourseService {
    /**
     * 查询全部课程
     */
    List<Course> findAll();
    /**
     * 根据名字查询相应课程
     */
    List<Course> findAllByName(String name);
    /**
     * 通过id删除相应课程
     */
    void delete(String id);

    /**
     * 添加一门课程
     */
    void add(Course course);

    /**
     * 更新一门课程
     */
    void update(Course course);

    /**
     * 查询相同专业的课程
     */
    List<String> findSameSpecialtyCourses(String name);
}
