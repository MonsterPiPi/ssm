package com.example.dao;

import com.example.bean.Course;
import com.example.bean.Stucourse;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by LiQian_Nice on 2018/2/19
 *
 * 学生与课程Dao的接口
 */
public interface IStucourseDao {

    /**
     * 根据学生查询相应选择的所有课程
     */
    @Select("select  c.name,c.schooltime,c.addr,c.credit,c.courseInfo,c.teacherName,c.teacherInfo,c.isFinish,c.specialtyId from tb_stucourse s,tb_course c where s.courseID=c.id and stuID = #{stuID}")
    List<Course> findCoursesByStuID(String stuID);

    /**
     * 一位同学添加课程
     */
    @Insert("insert into tb_stucourse(stuID,courseID) values (#{stuID},#{courseID})")
    void add(Stucourse stucourse);

    /**
     *  一位同学删除课程
     */
    @Delete("delete form tb_stucourse where id = #{id}")
    void delete(String id);

}
