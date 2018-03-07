package com.example.controller;

import com.example.bean.Result;
import com.example.bean.Userlogin;
import com.example.service.IUserloginService;
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
 *
 *  * RESTful API 设计
 * |请求类型|请求路径|功能
 * |GET|/girls|获取女生列表|
 * |POST|/girls|添加一个女生|
 * |GET|/girls/id|通过 id 查询一个女生|
 * |PUT|/girls/id|通过 id 更新一个女生|
 * |DELETE|girls/id|通过 id 删除一个女生|
 * |GET|girls/age/{age}|通过 age 获取女生列表|
 * |POST|girls/two|模拟测试事物处理|
 * |GET|girls/getAge/{id}|通过 id 查询女生年龄,模拟实现统一异常处理|
 */
@RequestMapping("/users")
@Controller
@Api(value = "登陆用户的接口", tags = {"登陆用户的接口"},description = "登陆用户的接口")
public class UserloginController {

    private static Logger logger= LoggerFactory.getLogger(UserloginController.class);

    @Autowired
    private IUserloginService userloginService;

    @GetMapping("/index")
    @ApiOperation(value = "测试页面跳转", notes = "测试页面跳转", httpMethod = "GET")
    public  String index(){
        return "userLogin";
    }

    @GetMapping("/")
    @ResponseBody
    @ApiOperation(value = "获取全部用户列表", notes = "获取全部用户列表", httpMethod = "GET", response = Userlogin.class)
    public Result findAll(){
        List<Userlogin> list=userloginService.findAll();
        if (list!=null){
            return ResultUtil.success(list);
        }else {
            return ResultUtil.error(0001,"未知错误");
        }

    }
    @PostMapping("/{userlogin}")
    @ResponseBody
    @ApiOperation(value = "添加一位用户", notes = "添加一位用户", httpMethod = "POST", response = Userlogin.class)
    public Result add(@Valid Userlogin userlogin,BindingResult bindingResult){

        logger.info(userlogin.getId());//测试是否获取到用户信息
        if (userlogin!=null){
            userloginService.add(userlogin);
            return ResultUtil.success();
        }else {
            return ResultUtil.error(1, "用户信息不完全");
        }

    }
    @GetMapping("/{id}")
    @ResponseBody
    @ApiOperation(value = "根据id查询一位用户信息", notes = "根据id查询用户信息", httpMethod = "GET", response = Userlogin.class)
    public Result findById(@PathVariable("id") String id){
        //bindingResult 必须紧跟在被验证参数后头，规定如此的.例如@Valid Userlogin userlogin1, BindingResult bindingResult
        //ResultUtil.error(1, bindingResult.getFieldError().getDefaultMessage());
        logger.info(id);//测试id是否输入进去
        if (id!=null){
            Userlogin userlogin=userloginService.findById(id);
            return ResultUtil.success(userlogin);
        }else {
            return ResultUtil.error(1,"id不能为空");
        }

    }
    @PutMapping("/{userlogin}")
    @ResponseBody
    @ApiOperation(value = "更新一位用户信息", notes = "更新用户信息", httpMethod = "PUT", response = Userlogin.class)
    public Result update(@Valid Userlogin userlogin){
        userloginService.update(userlogin);
        return ResultUtil.success();
    }
    @DeleteMapping("/{id}")
    @ResponseBody
    @ApiOperation(value = "根据id删除一位用户", notes = "根据id删除一位用户", httpMethod = "DELETE", response = Userlogin.class)
    public Result delete(@PathVariable("id") String id){
        if (id!=null){
            userloginService.delete(id);
            return ResultUtil.success();
        }else {
            return ResultUtil.error(1,"id不能为空");
        }

    }
    @GetMapping("/type/{type}")
    @ResponseBody
    @ApiOperation(value = "根据type获取用户列表", notes = "根据type获取用户列表", httpMethod = "GET", response = Userlogin.class)
    public Result findAllByType(@PathVariable("type") String type){

        if (type!=null){
            List<Userlogin> list=userloginService.findAllByType(type);
            if (list==null&&list.size()==0){
                return ResultUtil.error(1,"类型不存在");
            }else {
                return ResultUtil.success(list);
            }
        }else {
            return ResultUtil.error(1,"type不能为空");
        }
    }
    @GetMapping("/getType/{id}")
    @ResponseBody
    @ApiOperation(value = "根据id查询用户类型", notes = "根据id查询用户类型", httpMethod = "GET", response = Userlogin.class)
    public Result getTypeById(@PathVariable("id") String id){
        if (id!=null){
            String type=userloginService.getTypeById(id);
            return ResultUtil.success(type);
        }else {
            return ResultUtil.error(1,"id不能为空");
        }

    }
}
