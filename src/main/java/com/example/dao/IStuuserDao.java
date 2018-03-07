package com.example.dao;

import com.example.bean.Stuuser;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * Created by LiQian_Nice on 2018/2/17
 *
 * 学生Dao的接口
 */
public interface IStuuserDao {
    /**
     * 添加学生
     */
    @Insert("INSERT INTO tb_stuuser (id,stuName, stuNo,specialtyId,stuSex,birthday,homeAddr,tel,addr)" +
            " VALUES(#{id},#{stuName},#{stuNo},#{specialtyId},#{stuSex},#{birthday},#{homeAddr},#{tel},#{addr})")
    void add(Stuuser stuuser);

    /**
     * 更新学生信息
     */
    @Update("update tb_stuuser set stuName = #{stuName},stuNo = #{stuNo},specialtyId = #{specialtyId},stuSex= #{stuSex},birthday = #{birthday}, homeAddr= #{homeAddr},tel = #{tel},addr = #{addr} where id= #{id}")
    void update(Stuuser stuuser);
    /**
     * 查询所有学生
     */
    @Select("select * from tb_stuuser")
    List<Stuuser> findAll();

    /**
     * 查询相同专业的学生
     */
    @Select("select u.stuName from tb_stuuser u,tb_specialty s  where u.specialtyId = s.id and name= #{name}")
    List<String> findSameSpecialtyStuuser(String name);

    /**
     * 删除一位学生根据id
     */
    @Delete("delete from tb_stuuser where id = #{id}")
    void delete(String id);
}
