package com.example.service;

import com.example.bean.Specialty;

import java.util.List;

/**
 * Created by LiQian_Nice on 2018/2/19
 *
 * 维护专业的接口
 */
public interface ISpecialtyService {

    List<Specialty> getAllSpecialty();

    void addSpecialty(Specialty specialty);
}
