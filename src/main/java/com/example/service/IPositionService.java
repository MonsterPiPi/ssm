package com.example.service;

import com.example.bean.Position;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

/**
 * Created by LiQian_Nice on 2018/2/10
 *
 * 维护职位相关的功能的接口
 */
public interface IPositionService {
    /**
     * 添加职位
     */
    boolean addPosition(Position position);

    /**
     * 通过id查找某一职位
     */
    @Cacheable(value = { "menuCache" })
    Position getPositionById(int positionId);

    /**
     * 获取全部职位信息
     */
    List<Position> getAllPosition();
    /**
     * 根据id删除某一职位
     */
    void deletePosition(int positionId);

    /**
     * 更新职位信息
     */
    void update(Position position);
}
