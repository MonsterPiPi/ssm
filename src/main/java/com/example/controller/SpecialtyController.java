package com.example.controller;

import com.example.bean.Result;
import com.example.bean.Specialty;
import com.example.service.ISpecialtyService;
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
@RequestMapping("specialty")
@Controller
@Api(value = "学生专业管理接口",tags = {"学生专业管理接口"},description = "学生专业管理接口")
public class SpecialtyController {

    private static Logger logger= LoggerFactory.getLogger(SpecialtyController.class);

    @Autowired
    private ISpecialtyService specialtyService;

    @GetMapping("/")
    @ResponseBody
    @ApiOperation(value = "获取全部专业列表", notes = "获取全部专业列表", httpMethod = "GET", response = Specialty.class)
    public Result findAll(){
        List<Specialty> specialtyList=specialtyService.findAll();
        return ResultUtil.success(specialtyList);
    }

    @GetMapping("/{name}")
    @ResponseBody
    @ApiOperation(value = "根据名称获取相同专业列表",notes = "根据名称获取相同专业列表",httpMethod = "GET",response = Specialty.class)
    public Result findAllByName(@PathVariable("name") String name){
        List<Specialty> specialtyList=specialtyService.findAllByName(name);
        return ResultUtil.success(specialtyList);
    }

    @PostMapping("/{specialty}")
    @ResponseBody
    @ApiOperation(value = "添加一个专业",notes = "添加一个专业",httpMethod = "POST",response = Specialty.class)
    public Result add(@Valid Specialty specialty){
        specialtyService.add(specialty);
        return ResultUtil.success();
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    @ApiOperation(value = "删除一个专业",notes = "删除一个专业",httpMethod = "DELETE",response = Specialty.class)
    public Result delete(@PathVariable("id") String id){
        specialtyService.delete(id);
        return ResultUtil.success();
    }

    @PutMapping("/{specialty}")
    @ResponseBody
    @ApiOperation(value = "修改一个专业",notes = "修改一个专业",httpMethod = "PUT",response = Specialty.class)
    public Result update(@Valid Specialty specialty){
        specialtyService.update(specialty);
        return ResultUtil.success();
    }
}
