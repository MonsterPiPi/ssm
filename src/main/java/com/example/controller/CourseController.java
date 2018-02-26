package com.example.controller;

import com.example.bean.Course;
import com.example.bean.Result;
import com.example.service.ICourseService;
import com.example.util.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by LiQian_Nice on 2018/2/19
 */
@RequestMapping("courses")
@Controller
@Api(value = "学生课程接口", tags = {"学生课程接口"},description = "学生课程接口")
public class CourseController {

    private static Logger logger= LoggerFactory.getLogger(CourseController.class);

    @Autowired
    private ICourseService courseService;

    @GetMapping("/")
    @ResponseBody
    @ApiOperation(value = "获取全部课程列表", notes = "获取全部课程列表", httpMethod = "GET", response = Course.class)
    public Result findAll(){
        return ResultUtil.success();
    }
}
