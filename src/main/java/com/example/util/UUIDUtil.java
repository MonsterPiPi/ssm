package com.example.util;

import java.util.UUID;

/**
 * Created by IntelliJ IDEA.
 * User : 51103942@qq.com
 * Date : 2017/12/31
 * Time : 11:02
 * Talk is cheap. Show me the code.
 */
//激活码工具类
public  class UUIDUtil {

    public static String getUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }
    //生成64位的激活码
    public static String getCode(){
        return UUIDUtil.getUUID()+UUIDUtil.getUUID();//64位
    }

    /**
     * 随机生成6位随机验证码
     * 方法说明
     */
    public static String createRandomVcode(){
        //验证码
        String vcode = "";
        for (int i = 0; i < 6; i++) {
            vcode = vcode + (int)(Math.random() * 9);
        }
        return vcode;
    }
}
