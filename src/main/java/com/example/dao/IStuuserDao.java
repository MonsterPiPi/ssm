package com.example.dao;

import com.example.bean.Stuuser;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

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
    void addStuuser(Stuuser stuuser);


    @Select("select u.stuName from tb_stuuser u,tb_specialty s  where u.specialtyId = s.id and name= #{name}")
    List<String> findSameSpecialtyStuuser(String name);
}
