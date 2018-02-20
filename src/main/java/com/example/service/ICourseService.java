package com.example.service;

import com.example.bean.Course;

import java.util.List;

/**
 * Created by LiQian_Nice on 2018/2/19
 *
 * 维护课程相关的接口
 */
public interface ICourseService {

    List<Course> getAllCourse();

    List<Course> getCoursesByName(String name);

    boolean deleteCourseById(String id);
}
