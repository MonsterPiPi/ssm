package com.example.util;


import com.example.bean.Result;
import com.example.enums.ResultEnums;

public class ResultUtil {
    public static Result success(Object object){
        Result result=new Result();
        result.setCode(0);
        result.setMsg(ResultEnums.CODE_SUCCESS.getMsg());
        result.setData(object);
        return result;
    }

    public static Result success(){
        return success(null);
    }

    public static Result error(Integer code){
        Result result=new Result();
        result.setCode(code);
        result.setMsg(ResultEnums.msg(code));
        return result;
    }
    public static Result error(Integer code,String msg){
        Result result=new Result();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }
}
