package com.example.controller;

import com.example.pojo.Categories;
import com.example.service.CategoriesService;
import com.example.util.DateUtil;
import com.example.util.Result;
import com.example.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User : 51103942@qq.com
 * Date : 2018/1/3
 * Time : 21:17
 * Talk is cheap. Show me the code.
 */
@Controller
@RequestMapping(value = "/categories")
public class CategoriesController {

    private Categories categories=new Categories();
    private List<Categories> list;
    @Autowired
    public CategoriesService categoriesService;

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    @ResponseBody
    public Result add(String name){
        categories.setName(name);
        categories.setCreateDate(DateUtil.nowDate());
        categoriesService.save(categories);
        return ResultUtil.success();
    }

    @RequestMapping(value = "/all",method = RequestMethod.POST)
    @ResponseBody
    public Result all(){
        list=categoriesService.findAll();
        if (list!=null){
            return ResultUtil.success(list);
        }else {
            return ResultUtil.error();
        }

    }
}
