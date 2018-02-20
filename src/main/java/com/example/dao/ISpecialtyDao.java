package com.example.dao;

import com.example.bean.Specialty;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by LiQian_Nice on 2018/2/19
 *
 * 专业Dao的接口
 */
public interface ISpecialtyDao {

    /**
     * 查询所有专业
     */
    @Select("select * from tb_specialty ")
    List<Specialty> getAllSpecialty();
}
