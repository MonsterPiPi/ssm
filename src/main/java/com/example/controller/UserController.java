package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by IntelliJ IDEA.
 * User : 51103942@qq.com
 * Date : 2018/1/1
 * Time : 23:59
 * Talk is cheap. Show me the code.
 */
@Controller
public class UserController {

    @RequestMapping("/index")
    public  String test(){
        return "index";
    }
}
