package com.example.controller;

import com.example.bean.Result;
import com.example.bean.Stuuser;
import com.example.bean.Userlogin;
import com.example.service.IStuuserService;
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
@RequestMapping("stuuser")
@Controller
@Api(value = "学生管理接口",tags = {"学生管理接口"},description = "学生管理接口")
public class StuuserController {

    private static Logger logger= LoggerFactory.getLogger(StucourseController.class);

    @Autowired
    private IStuuserService stuuserService;

    @GetMapping("/")
    @ResponseBody
    @ApiOperation(value = "获取全部用户列表", notes = "获取全部用户列表", httpMethod = "GET", response = Stuuser.class)
    public Result findAll(){
        List<Stuuser> list=stuuserService.findAll();
        if (list!=null){
            return ResultUtil.success(list);
        }else {
            return ResultUtil.error(0001,"未知错误");
        }

    }
    @PostMapping("/{stuuser}")
    @ResponseBody
    @ApiOperation(value = "添加一位用户", notes = "添加一位用户", httpMethod = "POST", response = Stuuser.class)
    public Result add(@Valid Stuuser stuuser, BindingResult bindingResult){

        logger.info(stuuser.getId());//测试是否获取到用户信息
        if (stuuser!=null){
            stuuserService.add(stuuser);
            return ResultUtil.success();
        }else {
            return ResultUtil.error(1, "用户信息不完全");
        }

    }
    @PutMapping("/{stuuser}")
    @ResponseBody
    @ApiOperation(value = "更新学生信息",notes = "更新学生信息",httpMethod = "PUT",response = Stuuser.class)
    public Result update(@Valid Stuuser stuuser){
        stuuserService.update(stuuser);
        return ResultUtil.success();
    }
    @GetMapping("/{name}")
    @ResponseBody
    @ApiOperation(value = "查询相同专业的学生", notes = "查询相同专业的学生", httpMethod = "GET", response = Stuuser.class)
    public Result findSameSpecialtyStuuser(@PathVariable("name") String name){
        //bindingResult 必须紧跟在被验证参数后头，规定如此的.例如@Valid Userlogin userlogin1, BindingResult bindingResult
        //ResultUtil.error(1, bindingResult.getFieldError().getDefaultMessage());
        logger.info(name);//测试id是否输入进去
        if (name!=null){
            List<String> stringList=stuuserService.findSameSpecialtyStuuser(name);
            return ResultUtil.success(stringList);
        }else {
            return ResultUtil.error(1,"名称不能为空");
        }

    }

    @DeleteMapping("/{id}")
    @ResponseBody
    @ApiOperation(value = "根据id删除一位学生", notes = "根据id删除一位学生", httpMethod = "DELETE", response = Stuuser.class)
    public Result delete(@PathVariable("id") String id){
        if (id!=null){
            stuuserService.delete(id);
            return ResultUtil.success();
        }else {
            return ResultUtil.error(1,"id不能为空");
        }

    }

}
