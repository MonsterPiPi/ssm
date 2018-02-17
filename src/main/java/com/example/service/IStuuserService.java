package com.example.service;

import com.example.bean.Stuuser;

/**
 * Created by LiQian_Nice on 2018/2/17
 *
 * 维护学生信息相关功能的接口
 */
public interface IStuuserService {

    /**
     * 添加学生
     */
    boolean addStuuser(Stuuser stuuser);
}
