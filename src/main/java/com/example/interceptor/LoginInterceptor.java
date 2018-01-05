package com.example.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by IntelliJ IDEA.
 * User : 51103942@qq.com
 * Date : 2018/1/4
 * Time : 19:27
 * Talk is cheap. Show me the code.
 */
public class LoginInterceptor implements HandlerInterceptor {


    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        System.out.println(" action之前执行！！！");
        String requestURI = httpServletRequest.getRequestURI();
        if (requestURI.indexOf("/home/toHome") > 0) {
            //说明处在编辑的页面
            HttpSession session = httpServletRequest.getSession();
            String username = (String) session.getAttribute("username");
            if (username != null) {
                //登陆成功的用户
                return true;
            } else {
                //sendRedirect重定向,会改变浏览器URL地址
                //forword请求转发不会改变浏览器URL地址
                httpServletResponse.sendRedirect("/mavenSpringMVC/user/toLogin");
                return false;
            }
        }else{
            return true;
        }
    }


    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        System.out.println("action执行之后，生成视图之前执行！！");
    }

    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        System.out.println("最后执行！！！一般用于释放资源！！");
    }
}
