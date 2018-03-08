package com.example.controller;

import com.example.bean.Course;
import com.example.bean.Result;
import com.example.bean.Stucourse;
import com.example.service.IStucourseService;
import com.example.util.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


/**
 * Created by LiQian_Nice on 2018/2/19
 */
@RequestMapping("stucourse")
@Controller
@Api(value = "学生课程管理接口",tags = {"学生课程管理接口"},description = "学生课程管理接口")
public class StucourseController {

    private static Logger logger= LoggerFactory.getLogger(StucourseController.class);

    @Autowired
    private IStucourseService stucourseService;

    @PostMapping("/{stucourse}")
    @ResponseBody
    @ApiOperation(value = "一位同学添加一门课程", notes = "一位同学添加一门课程", httpMethod = "POST", response = Stucourse.class)
    public Result add(@Valid Stucourse stucourse, BindingResult bindingResult){

        logger.info(stucourse.getStuID());//测试是否获取
        if (stucourse!=null){
            stucourseService.add(stucourse);
            return ResultUtil.success();
        }else {
            return ResultUtil.error(1, "信息不完整");
        }

    }
    @GetMapping("/{stuID}")
    @ResponseBody
    @ApiOperation(value = "根据学生id查询所选择的所有课程",notes = "根据学生id查询所选择的所有课程",httpMethod = "GET",response = Stucourse.class)
    public Result findCoursesByStuID(@PathVariable("stuID") String stuID){
        logger.info(stuID);
        if (stuID!=null){
            List<Course> courseList=stucourseService.findCoursesByStuID(stuID);
            return ResultUtil.success(courseList);
        }else {
            return ResultUtil.error(1,"学生id已失效");
        }
    }
    @DeleteMapping("/{id}")
    @ResponseBody
    @ApiOperation(value = "根据id删除同学所选择的课程", notes = "根据id删除同学所选择的课程", httpMethod = "DELETE", response = Stucourse.class)
    public Result delete(@PathVariable("id") String id){
        if (id!=null){
            stucourseService.delete(id);
            return ResultUtil.success();
        }else {
            return ResultUtil.error(1,"id不能为空");
        }

    }
}
