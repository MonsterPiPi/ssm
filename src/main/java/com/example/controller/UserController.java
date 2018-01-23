package com.example.controller;

import com.example.pojo.User;
import com.example.service.UserService;
import com.example.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import javax.mail.MessagingException;
import javax.servlet.http.HttpSession;
import java.security.GeneralSecurityException;


/**
 * Created by IntelliJ IDEA.
 * User : 51103942@qq.com
 * Date : 2018/1/1
 * Time : 23:59
 * Talk is cheap. Show me the code.
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {

    private User user=new User();

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/index" )
    @ResponseBody
    public Result test(){
        user.setNickName("111");
        user.setPassword("111");
        user.setLocation("111");
        return ResultUtil.success(user);
    }


    @RequestMapping(value = "/checkLoginEmail",method = RequestMethod.GET)
    @ResponseBody
    public Result checkLoginEmail(String email){
        if(userService.findByEmail(email)!=null){

            return ResultUtil.success();
        }else {
            return ResultUtil.error();
        }

    }

    @RequestMapping(value="/register" ,method= RequestMethod.POST)
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
        user.setJoinDate(DateUtil.nowDate());
        //System.out.println(email);
        if(userService.save(user)){
            MailUtil.sendMail(MailUtil.registerTitle,email,code);
            return ResultUtil.success(user);
        }else {
            return ResultUtil.error();
        }

    }
    @RequestMapping(value="/login" ,method= RequestMethod.POST)
    @ResponseBody
    public Result findByEmailAndPassword(HttpSession httpSession, String email, String password) {
        User loginUser=userService.findByEmailAndPassword(email,password);
        if(loginUser!=null){
            //user会自己注入session中
            //将email放入session作用域中，这样转发页面也可以取到这个数据。
            httpSession.setAttribute("user",loginUser);
            httpSession.setAttribute("username",loginUser.getNickName());
            System.out.println(httpSession.getAttribute("username"));
            return ResultUtil.success();
        }else {
            return ResultUtil.error();
        }

    }
    @RequestMapping(value = "exit",method = RequestMethod.POST)
    @ResponseBody
    public Result exit(HttpSession session){
        session.removeAttribute("username");
        return ResultUtil.success();
    }

    @RequestMapping(value = "about",method = RequestMethod.GET)
    @ResponseBody
    public Result about(HttpSession session){
        User sessionUser= (User) session.getAttribute("user");
        user.setNickName(sessionUser.getNickName());
        user.setLocation(sessionUser.getLocation());
        user.setJoinDate(sessionUser.getJoinDate());
        user.setEmail(sessionUser.getEmail());
        user.setState(sessionUser.getState());
        user.setPhone(sessionUser.getPhone());
        user.setPhoto(sessionUser.getPhoto());
        return ResultUtil.success(user);
    }
    /**
     * 页面跳转控制
     * @return
     */
    @RequestMapping(value="/toLogin " ,method= RequestMethod.GET)
    public String toLogin(){
        return "login";
    }

    @RequestMapping(value = "/toRegister",method = RequestMethod.GET)
    public String toRegister(){
        return "register";
    }


}
