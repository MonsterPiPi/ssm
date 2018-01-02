package com.example.controller;

import com.example.pojo.User;
import com.example.service.UserService;
import com.example.util.MailUtil;
import com.example.util.Result;
import com.example.util.ResultUtil;
import com.example.util.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.mail.MessagingException;
import java.security.GeneralSecurityException;

/**
 * Created by IntelliJ IDEA.
 * User : 51103942@qq.com
 * Date : 2018/1/1
 * Time : 23:59
 * Talk is cheap. Show me the code.
 */
@Controller
public class UserController {

    private User user=new User();
    @Autowired
    public UserService userService;

    @RequestMapping(value = "/index" )
    @ResponseBody
    public Result test(){
        user.setNickName("111");
        user.setPassword("111");
        user.setLocation("111");
        return ResultUtil.success(user);
    }

    @RequestMapping(value="/toLogin " ,method= RequestMethod.GET)
    public String toLogin(){
      return "login";
    }

    @RequestMapping(value = "/toRegister",method = RequestMethod.GET)
    public String toRegister(){
        return "register";
    }

    @RequestMapping(value="/userRegister" ,method= RequestMethod.POST)
    @ResponseBody
    public Result save(String email,String password,String nickName,String location,String phone) throws GeneralSecurityException, MessagingException {
        user.setEmail(email);
        user.setPassword(password);
        String code=UUIDUtil.getCode();
        user.setCode(code);
        user.setState("0");//0代表未激活
        user.setNickName(nickName);
        user.setLocation(location);
        user.setPhone(phone);
        //System.out.println(email);
        if(userService.save(user)){
            MailUtil.sendMail(email,code);
            return ResultUtil.success(user);
        }else {
            return ResultUtil.error();
        }

    }
    @RequestMapping(value="/userLogin" ,method= RequestMethod.POST)
    @ResponseBody
    public Result findByEmailAndPassword(String email,String password) {
        if(userService.findByEmailAndPassword(email,password)){
            return ResultUtil.success();
        }else {
            return ResultUtil.error();
        }

    }
}
