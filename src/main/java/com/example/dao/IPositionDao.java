package com.example.dao;

import com.example.bean.Position;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * Created by LiQian_Nice on 2018/2/10
 *
 * 职位Dao的接口
 */

public interface IPositionDao {

    /**
     * 添加职位
     */
    @Insert("INSERT INTO POSITION (NAME, DESCRIPTION) VALUES(#{name}, #{description})")
    boolean addPosition(Position position);

    /**
     * 通过id查找某一职位
     */
    @Select("SELECT * FROM POSITION WHERE P_ID = #{_parameter}")
    Position getPositionById(int positionId);

    /**
     * 获取全部职位信息
     */
    @Select("SELECT * FROM POSITION")
    List<Position> getAllPosition();
    /**
     * 根据id删除某一职位
     */
    @Delete("DELETE FROM POSITION WHERE P_ID = #{_parameter}")
    void deletePosition(int positionId);

    /**
     * 更新职位信息
     */
    @Update("UPDATE POSITION SET NAME = #{name}, DESCRIPTION = #{description} where P_ID = #{_parameter}")
    void update(Position position);

}
