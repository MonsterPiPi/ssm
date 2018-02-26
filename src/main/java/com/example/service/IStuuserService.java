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
     * 添加学生
     */
    void addStuuser(Stuuser stuuser);

    /**
     * 查询一个专业的所有学生
     */
    List<String> findSameSpecialtyStuuser(String name);
}
