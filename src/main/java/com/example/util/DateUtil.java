package com.example.util;

import java.text.SimpleDateFormat;

/**
 * Created by IntelliJ IDEA.
 * User : 51103942@qq.com
 * Date : 2018/1/3
 * Time : 11:33
 * Talk is cheap. Show me the code.
 */
public class DateUtil {
    //获取当前时间
    public static String nowDate(){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(df.format(System.currentTimeMillis()));
        return df.format(System.currentTimeMillis());
    }
}
