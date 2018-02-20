package com.example.controller;

import com.example.service.ISpecialtyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by LiQian_Nice on 2018/2/19
 */
@RequestMapping("specialty")
@Controller
public class SpecialtyController {

    private static Logger logger= LoggerFactory.getLogger(SpecialtyController.class);

    @Autowired
    private ISpecialtyService specialtyService;

}
