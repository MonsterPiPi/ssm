package com.example.controller;

import com.example.pojo.Blog;
import com.example.pojo.Categories;
import com.example.pojo.User;
import com.example.service.BlogService;
import com.example.service.CategoriesService;
import com.example.util.Result;
import com.example.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpSession;
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
    private Categories ca=new Categories();

    @Autowired
    public BlogService blogService;

    @Autowired
    public CategoriesService categoriesService;

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    @ResponseBody
    public Result saveBlog(String title, String createTime, String profile, String context, HttpSession httpSession) {

        System.out.println(context);
        User user=new User();

        user.setUid((Integer)httpSession.getAttribute("username"));
        blog.setTitle(title);
        blog.setCreateTime(createTime);
        blog.setUser(user);
        blog.setFonts("未知");
        //blogService.save(blog);
        System.out.println(profile);
        return ResultUtil.success(blog);
    }


    @RequestMapping(value="/search" ,method= RequestMethod.POST)
    @ResponseBody
    public Result search(String searchText){

        list=blogService.findBlogs(searchText);
        if (list!=null){
            return  ResultUtil.success(list);
        }else {
            return ResultUtil.error();
        }
    }
}
