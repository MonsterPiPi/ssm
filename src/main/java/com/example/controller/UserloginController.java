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
import org.springframework.http.ResponseEntity;
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
@RequestMapping("/user")
@Controller
@Api(value = "/user", tags = "登陆用户的接口",description = "登陆用户的接口")
public class UserloginController {

    private static Logger logger= LoggerFactory.getLogger(UserloginController.class);

    @Autowired
    private IUserloginService userloginService;
    @GetMapping("index")
    public  String index(){
        return "index";
    }
    @GetMapping("/getUser/{id}")
    @ResponseBody
    @ApiOperation(value = "根据id获取用户信息", notes = "根据id获取用户信息", httpMethod = "GET", response = Userlogin.class)
    public Result test(@PathVariable("id") String id){
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
}
