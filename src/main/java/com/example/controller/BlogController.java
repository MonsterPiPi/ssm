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

/**
 * Created by IntelliJ IDEA.
 * User : 51103942@qq.com
 * Date : 2018/1/3
 * Time : 18:05
 * Talk is cheap. Show me the code.
 */
@Controller
@SessionAttributes({"user","user_id"})
public class BlogController {
    private Blog blog=new Blog();
    private Categories ca=new Categories();
    @Autowired
    public BlogService blogService;
    @Autowired
    public CategoriesService categoriesService;

    @RequestMapping(value = "/saveBlog",method = RequestMethod.POST)
    @ResponseBody
    public Result saveBlog(String title, String createTime, String categories, ModelMap map) {
        ca.setName(categories);
        ca.setCreateDate(createTime);
        categoriesService.save(ca);
        User user=new User();
        user.setUid((Integer) map.get("user_id"));
        blog.setTitle(title);
        blog.setCreateTime(createTime);
        blog.setUser(user);
        blogService.save(blog);
        System.out.println(categories);
        return ResultUtil.success(blog);
    }
}
