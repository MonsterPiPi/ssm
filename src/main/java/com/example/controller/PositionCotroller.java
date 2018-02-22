package com.example.controller;

import com.example.bean.Position;
import com.example.service.IPositionService;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by LiQian_Nice on 2018/2/11
 *
 * 职位控制器
 */
@Controller
@RequestMapping(value = "position")
public class PositionCotroller {


    private static Logger logger = LoggerFactory.getLogger(PositionCotroller.class);

    @Autowired
    private IPositionService positionService;


    /**
     * 接收RESTful风格的请求，其接收方式为GET
     */
    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    @ResponseBody
    public Position selectPosition(@PathVariable("id") int id) {
        //查看数据的接收
        logger.info("id="+id);
        Position position1=new Position();
        position1.setName("asasa");
        position1.setDescription("sadsadas");
        //positionService.deletePosition(2);
        Position position =positionService.getPositionById(id);
        return position;
    }
}
