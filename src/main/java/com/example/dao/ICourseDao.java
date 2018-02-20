package com.example.dao;

import com.example.bean.Course;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by LiQian_Nice on 2018/2/19
 *
 * 课程Dao的接口
 */
public interface ICourseDao {

    /**
     * 查询全部课程
     */
    @Select("select * from tb_course")
    List<Course> getAllCourse();

    /**
     * 根据名字查询相应课程
     */
    @Select("select * from tb_course where name like '%' #{_parameter} '%'")
    List<Course> getCoursesByName(String name);

    /**
     * 通过id删除相应课程
     */
    @Delete("delete from tb_course where id = #{_parameter}")
    void deleteCourseById(String id);
}
