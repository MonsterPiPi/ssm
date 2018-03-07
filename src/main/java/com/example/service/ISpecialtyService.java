package com.example.service;

import com.example.bean.Specialty;

import java.util.List;

/**
 * Created by LiQian_Nice on 2018/2/19
 *
 * 维护专业的接口
 */
public interface ISpecialtyService {

    /**
     * 查询所有专业
     */
    List<Specialty> findAll();

    /**
     * 根据名字查询相同专业
     */
    List<Specialty> findAllByName(String name);

    /**
     * 添加一个专业
     */
    void add(Specialty specialty);

    /**
     * 删除一个专业
     */
    void delete(String id);

    /**
     * 更新一个专业
     */
    void update(Specialty specialty);
}
