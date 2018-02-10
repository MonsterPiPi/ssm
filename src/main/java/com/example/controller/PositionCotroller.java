package com.example.controller;

import com.example.service.IPositionService;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by LiQian_Nice on 2018/2/11
 *
 * 职位控制器
 */
@Controller

public class PositionCotroller {


    private static Logger logger = LoggerFactory.getLogger(PositionCotroller.class);
    @Autowired
    private IPositionService positionService;
    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public String index(){
        int i=1;
        logger.info(positionService.getPositionById(i).getName());
        return "index";
    }
}
