package com.example.service;

import com.example.bean.Stuuser;

import java.util.List;

/**
 * Created by LiQian_Nice on 2018/2/17
 *
 * 维护学生信息相关功能的接口
 */
public interface IStuuserService {



    /**
     * 查询一个专业的所有学生
     */
    List<String> findSameSpecialtyStuuser(String name);

    /**
     * 查询所有
     */
    List<Stuuser> findAll();

    /**
     * 添加学生
     */
    void add(Stuuser stuuser);

    /**
     * 删除一位学生
     */
    void delete(String id);

    /**
     * 更新学生信息
     */
    void update(Stuuser stuuser);
}
