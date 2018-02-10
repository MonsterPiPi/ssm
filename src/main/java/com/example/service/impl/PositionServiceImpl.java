package com.example.service.impl;

import com.example.bean.Position;
import com.example.dao.IPositionDao;
import com.example.service.IPositionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by LiQian_Nice on 2018/2/10
 *
 * 维护职位相关的功能实现类
 */
@Service("positionService")
public class PositionServiceImpl implements IPositionService {

    @Resource
    private IPositionDao positionDao;

    @Override
    public Position getPositionById(int positionId) {

        return this.positionDao.getPositionById(positionId);
    }
}
