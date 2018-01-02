package com.example.controller;

import com.example.pojo.User;
import com.example.service.UserService;
import com.example.util.Result;
import com.example.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by IntelliJ IDEA.
 * User : 51103942@qq.com
 * Date : 2018/1/1
 * Time : 23:59
 * Talk is cheap. Show me the code.
 */
@Controller
public class UserController {

    @Autowired
    public UserService userService;

    @RequestMapping(value = "/index" )
    @ResponseBody
    public Result test(){
        User user=new User();
        user.setNickName("111");
        user.setPassword("111");
        user.setLocation("111");
        return ResultUtil.success(user);
    }

    @RequestMapping(value = "/login" )
    public String login(){
      return "login";
    }
}
