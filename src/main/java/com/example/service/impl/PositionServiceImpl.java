package com.example.service.impl;

import com.example.bean.Position;
import com.example.dao.IPositionDao;
import com.example.service.IPositionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

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
    public boolean addPosition(Position position) {
        return positionDao.addPosition(position);
    }

    @Override
    public Position getPositionById(int positionId) {

        return positionDao.getPositionById(positionId);
    }

    @Override
    public List<Position> getAllPosition() {
        return positionDao.getAllPosition();
    }

    @Override
    public void deletePosition(int positionId) {
        positionDao.deletePosition(positionId);
    }

    @Override
    public void update(Position position) {
        positionDao.update(position);
    }
}
