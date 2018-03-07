package com.example.dao;

import com.example.bean.Specialty;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

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
    List<Specialty> findAll();

    /**
     * 添加一个专业
     */
    @Insert("insert into tb_specialty(name,langthYear,enterYear,isFinish) values (#{name},#{langthYear},#{enterYear},#{isFinish})")
    void add(Specialty specialty);

    /**
     * 删除一个专业
     */
    @Delete("delete from tb_specialty where id = #{id}")
    void delete(String id);

    /**
     * 更新一个专业
     */
    @Update("update tb_specialty set name = #{name}, langthYear = #{langthYear},enterYear = #{enterYear},isFinish = #{isFinish} where id = #{id} ")
    void update(Specialty specialty);

    /**
     * 根据名字查询相同专业
     */
    @Select("select * from tb_specialty where name = #{name}")
    List<Specialty> findAllByName(String name);

}
