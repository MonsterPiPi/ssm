package com.example.dao;

import com.example.bean.Stuuser;
import org.apache.ibatis.annotations.Insert;

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
    boolean addStuuser(Stuuser stuuser);
}
