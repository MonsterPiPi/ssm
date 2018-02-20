package com.example.controller;

import com.example.bean.Userlogin;
import com.example.service.IUserloginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by LiQian_Nice on 2018/2/19
 */
@RequestMapping("user")
@Controller
public class UserloginController {

    private static Logger logger= LoggerFactory.getLogger(UserloginController.class);

    @Autowired
    private IUserloginService userloginService;

    @RequestMapping(value = "{id}",method = RequestMethod.GET)
    @ResponseBody
    public Userlogin test(@PathVariable("id") String id){
        logger.info(id);
        Userlogin userlogin=new Userlogin();
        userlogin.setId("1");
        userlogin.setLoginName("李前");
        userlogin.setPwd("111");
        userlogin.setType("管理员");
        userlogin.setMail("51103942@qq.com");
        return userlogin;
    }
}
