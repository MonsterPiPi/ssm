package com.example.controller;

import com.example.service.IStucourseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * Created by LiQian_Nice on 2018/2/19
 */
@RequestMapping("stucourse")
@Controller
public class StucourseController {

    private static Logger logger= LoggerFactory.getLogger(StucourseController.class);

    @Autowired
    private IStucourseService stucourseService;

}
