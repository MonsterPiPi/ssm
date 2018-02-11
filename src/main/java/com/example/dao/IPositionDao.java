package com.example.dao;

import com.example.bean.Position;
import org.apache.ibatis.annotations.Select;

/**
 * Created by LiQian_Nice on 2018/2/10
 *
 * 职位Dao的接口
 */

public interface IPositionDao {

    /**
     * 通过id查找某一职位
     */
    @Select("SELECT * FROM POSITION WHERE P_ID = #{_parameter}")
    Position getPositionById(int positionId);
}
