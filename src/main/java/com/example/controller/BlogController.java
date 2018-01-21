package com.example.controller;

import com.example.pojo.Blog;
import com.example.pojo.User;
import com.example.service.BlogService;
import com.example.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User : 51103942@qq.com
 * Date : 2018/1/3
 * Time : 18:05
 * Talk is cheap. Show me the code.
 */
@Controller
@RequestMapping(value = "/blog")
public class BlogController {
    private Blog blog=new Blog();
    private List<Blog> list;


    @Autowired
    public BlogService blogService;



    @RequestMapping(value = "/save",method = RequestMethod.POST)
    @ResponseBody
    public Result saveBlog(String title, String createTime, String profile, String context, HttpSession httpSession,HttpServletRequest req) throws IOException {
        //String realPath = req.getSession().getServletContext().getRealPath("/WEB-INF/statics/blog/");
        //System.out.println(realPath);
        User sessionUser= (User) httpSession.getAttribute("user");
        String FileName= UUIDUtil.getUUID();
        User user=new User();
        user.setUid(sessionUser.getUid());
        FileUtil.newFile(FileUtil.directory,FileName,context);
        // FileUtil.newFile(FileUtil.directoryIdea,FileName,context);
        blog.setTitle(title);
        blog.setCreateTime(createTime);
        blog.setUser(user);
        blog.setFonts("未知");
        blog.setCategories(profile);
        blog.setFileLocation(FileUtil.directory+FileName+".txt");
        blogService.save(blog);
        //System.out.println(profile);
        return ResultUtil.success(blog);
    }


    @RequestMapping(value = "/categories/all",method = RequestMethod.GET)
    @ResponseBody
    public Result findAllCategories(){
        list=blogService.findAllCategories();
        System.out.println(list.toString());
        if (list!=null){
            return ResultUtil.success(list);
        }else {
            return ResultUtil.error();
        }

    }
    @RequestMapping(value = "/openBlog",method = RequestMethod.POST)
    @ResponseBody
    public Result openBlog(String title){
        System.out.println(title);
        return ResultUtil.success();
    }


    @RequestMapping(value="/search" ,method= RequestMethod.POST)
    @ResponseBody
    public Result search(String searchText){
        list=blogService.findBlogs(searchText);
        if (list!=null){
            System.out.println(list.toString());
            return  ResultUtil.success(list);
        }else {
            return ResultUtil.error();
        }
    }

    @RequestMapping(value = "toOneBlog")
    public String toOneBlog(){
        list=blogService.findAll();
        System.out.println(list.toString());
        return "test";
    }



}
