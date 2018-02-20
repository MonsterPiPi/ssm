package com.example.bean;

/**
 * Created by LiQian_Nice on 2018/2/19
 *
 * 与用户登陆表相对应的实体类
 */
public class Userlogin {
    /**
     * 用户编号
     */
    private String id;
    /**
     * 登录名
     */
    private String loginName;
    /**
     * 密码
     */
    private String pwd;
    /**
     * 用户类型
     */
    private String type;
    /**
     * 邮箱
     */
    private String mail;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
}
