package com.example.service;

import com.example.bean.Course;
import com.example.bean.Stucourse;

import java.util.List;

/**
 * Created by LiQian_Nice on 2018/2/19
 *
 * 维护学生课程相关的接口
 */
public interface IStucourseService {

    /**
     * 一位同学添加一个课程
     */
    void add(Stucourse stucourse);

    /**
     * 删除一位同学所选择的课程
     */
    void delete(String id);

    /**
     * 根据学生id获取所选修的全部课程
     */
    List<Course> findCoursesByStuID(String stuID);
}
