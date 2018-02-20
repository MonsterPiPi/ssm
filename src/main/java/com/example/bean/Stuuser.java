package com.example.bean;

/**
 * Created by LiQian_Nice on 2018/2/17
 *
 * 与学生表对应的实体类
 */
public class Stuuser {
    /**
     * 学生编号
     */
    private String id;
    /**
     * 学生姓名
     */
    private String stuName;
    /**
     * 学号
     */
    private String stuNo;

    /**
     * 专业编号
     */
    private String specialtyId;

    /**
     * 性别
     */
    private String stuSex;

    /**
     * 出生日期
     */
    private String birthday;

    /**
     * 家庭住址
     */
    private String homeAddr;

    /**
     * 联系电话
     */
    private String tel;

    /**
     * 现住址
     */
    private String addr;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getStuNo() {
        return stuNo;
    }

    public void setStuNo(String stuNo) {
        this.stuNo = stuNo;
    }

    public String getSpecialtyId() {
        return specialtyId;
    }

    public void setSpecialtyId(String specialtyId) {
        this.specialtyId = specialtyId;
    }

    public String getStuSex() {
        return stuSex;
    }

    public void setStuSex(String stuSex) {
        this.stuSex = stuSex;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getHomeAddr() {
        return homeAddr;
    }

    public void setHomeAddr(String homeAddr) {
        this.homeAddr = homeAddr;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }
}
