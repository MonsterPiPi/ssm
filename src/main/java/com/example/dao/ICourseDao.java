package com.example.dao;

import com.example.bean.Course;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

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
    List<Course> findAll();
    /**
     * 根据名字查询相应课程
     */
    @Select("select * from tb_course where name like '%' #{_parameter} '%'")
    List<Course> findAllByName(String name);
    /**
     * 通过id删除相应课程
     */
    @Delete("delete from tb_course where id = #{_parameter}")
    void delete(String id);
    /**
     * 添加一门课程
     */
    @Insert("insert into tb_course (name,schooltime,addr,credit,courseInfo,teacherName,teacherInfo,isFinish,specialtyId)" +
            "values( #{name},#{schooltime},#{addr},#{credit},#{courseInfo},#{teacherName},#{teacherInfo},#{isFinish},#{specialtyId})")
    void add(Course course);
    /**
     * 更新一门课程
     */
    @Update("update tb_course set name = #{name} ,schooltime = #{schooltime}, credit = #{credit},courseInfo = #{courseInfo},teacherName = #{teacherName},teacherInfo= #{teacherInfo},isFinish = #{isFinish},specialtyId = #{specialtyId} where id = #{id}")
    void update(Course course);

    /**
     * 查询相同专业的课程
     */
    @Select("select u.name from tb_course u,tb_specialty s  where u.specialtyId = s.id and s.name= #{name}")
    List<String> findSameSpecialtyCourses(String name);
}
