package com.example.service;

import com.example.bean.Position;

/**
 * Created by LiQian_Nice on 2018/2/10
 *
 * 维护职位相关的功能的接口
 */
public interface IPositionService {
    /**
     * 通过id查找某一职位信息
     */
    public Position getPositionById(int positionId);
}
