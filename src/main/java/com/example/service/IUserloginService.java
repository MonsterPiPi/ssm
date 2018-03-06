package com.example.service;

import com.example.bean.Userlogin;

import java.util.List;

/**
 * Created by LiQian_Nice on 2018/2/19
 *
 * 维护用户登陆的接口
 */
public interface IUserloginService {
    /**
     * 查询全部登陆用户
     */
    List<Userlogin> findAll();

    /**
     * 添加一位用户
     */
    void add(Userlogin userlogin);

    /**
     * 根据id查询用户信息
     */
    Userlogin findById(String id);

    /**
     * 根据id删除用户
     */
    void delete(String id);

    /**
     * 根据类型查询所有用户
     */
    List<Userlogin> getAllByType(String type);

    /**
     * 根据id查询用户类型
     */
    String getTypeById(String id);

    /**
     * 更新用户信息
     */
    void update(Userlogin userlogin);
}
