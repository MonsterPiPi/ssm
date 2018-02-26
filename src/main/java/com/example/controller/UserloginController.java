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
        return ResultUtil.success();
    }
    @PostMapping("/{userlogin}")
    @ResponseBody
    @ApiOperation(value = "添加一位用户", notes = "添加一位用户", httpMethod = "POST", response = Userlogin.class)
    public Result add(@Valid Userlogin userlogin,BindingResult bindingResult){
        return ResultUtil.success();
    }
    @GetMapping("/{id}")
    @ResponseBody
    @ApiOperation(value = "根据id查询一位用户信息", notes = "根据id查询用户信息", httpMethod = "GET", response = Userlogin.class)
    public Result findById(@PathVariable("id") String id){
        //bindingResult 必须紧跟在被验证参数后头，规定如此的.例如@Valid Userlogin userlogin1, BindingResult bindingResult
        //ResultUtil.error(1, bindingResult.getFieldError().getDefaultMessage());
        logger.info(id);
        Userlogin userlogin=new Userlogin();
        userlogin.setId("1");
        userlogin.setLoginName("李前");
        userlogin.setPwd("111");
        userlogin.setType("管理员");
        userlogin.setMail("51103942@qq.com");
        return ResultUtil.success(userlogin);
    }
    @PutMapping("/{id}")
    @ResponseBody
    @ApiOperation(value = "根据id更新一位用户信息", notes = "根据id更新用户信息", httpMethod = "PUT", response = Userlogin.class)
    public Result update(@PathVariable("id") String id){
        //bindingResult 必须紧跟在被验证参数后头，规定如此的.例如@Valid Userlogin userlogin1, BindingResult bindingResult
        //ResultUtil.error(1, bindingResult.getFieldError().getDefaultMessage());
        return ResultUtil.success();
    }
    @DeleteMapping("/{id}")
    @ResponseBody
    @ApiOperation(value = "根据id删除一位用户", notes = "根据id删除一位用户", httpMethod = "DELETE", response = Userlogin.class)
    public Result delete(@PathVariable("id") String id){
        //bindingResult 必须紧跟在被验证参数后头，规定如此的.例如@Valid Userlogin userlogin1, BindingResult bindingResult
        //ResultUtil.error(1, bindingResult.getFieldError().getDefaultMessage());
        return ResultUtil.success();
    }
    @GetMapping("/type/{type}")
    @ResponseBody
    @ApiOperation(value = "根据type获取用户列表", notes = "根据type获取用户列表", httpMethod = "GET", response = Userlogin.class)
    public Result getAllByType(@PathVariable("type") String type){
        return ResultUtil.success();
    }
    @GetMapping("/getType/{id}")
    @ResponseBody
    @ApiOperation(value = "根据id查询用户类型", notes = "根据id查询用户类型", httpMethod = "GET", response = Userlogin.class)
    public Result getTypeById(@PathVariable("id") String id){
        return ResultUtil.success();
    }
}
