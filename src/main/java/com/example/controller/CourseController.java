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
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by LiQian_Nice on 2018/2/19
 */
@RequestMapping("courses")
@Controller
@Api(value = "课程管理接口", tags = {"课程管理接口"},description = "课程管理接口")
public class CourseController {

    private static Logger logger= LoggerFactory.getLogger(CourseController.class);

    @Autowired
    private ICourseService courseService;

    @GetMapping("/")
    @ResponseBody
    @ApiOperation(value = "获取全部课程列表", notes = "获取全部课程列表", httpMethod = "GET", response = Course.class)
    public Result findAll(){
        List<Course> list=courseService.findAll();
        if (list!=null){
            return ResultUtil.success(list);
        }else {
            return ResultUtil.error(1,"获取失败");
        }

    }

    @GetMapping("/{name}")
    @ResponseBody
    @ApiOperation(value = "根据名字查询相关课程",notes = "根据名字查询相关课程",httpMethod = "GET",response = Course.class)
    public Result findAllByName(@PathVariable("name") String name){
        if (name!=null){
            List<Course> list=courseService.findAllByName(name);
            return ResultUtil.success(list);
        }else {
            return ResultUtil.error(1,"姓名不能为空");
        }
    }

    @PostMapping("/{course}")
    @ResponseBody
    @ApiOperation(value = "添加一门课程",notes = "添加一门课程",httpMethod = "POST",response = Course.class)
    public Result add(@Valid Course course){
        courseService.add(course);
        return ResultUtil.success();
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    @ApiOperation(value = "根据id删除一个课程",notes = "根据id删除一个课程",httpMethod ="DELETE",response = Course.class)
    public Result delete(@PathVariable("id") String id){
        if (id!=null){
            courseService.delete(id);
            return ResultUtil.success();
        }else {
            return ResultUtil.error(1,"id不能为空");
        }

    }

    @PutMapping("/{course}")
    @ResponseBody
    @ApiOperation(value = "更新一个课程信息", notes = "更新课程信息", httpMethod = "PUT", response = Course.class)
    public Result update(@Valid Course course){
        courseService.update(course);
        return ResultUtil.success();
    }

    @GetMapping("/getCourse/{name}")
    @ResponseBody
    @ApiOperation(value = "查询相同专业的课程",notes = "查询相同专业的课程",httpMethod = "GET",response = Course.class)
    public Result findSameSpecialtyCourses(@PathVariable("name") String name){
        if (name!=null){
            List<String> stringList=courseService.findSameSpecialtyCourses(name);
            return ResultUtil.success(stringList);
        }else {
            return ResultUtil.error(1,"专业名称不能为空");
        }

    }

}
