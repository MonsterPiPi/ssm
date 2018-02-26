package com.example.bean;

import java.util.List;

/**
 * Created by LiQian_Nice on 2018/2/19
 *
 *  与专业表对应的实体类
 */
public class Specialty {
    /**
     * 专业编号
     */
    private String id;
    /**
     * 入学年份
     */
    private String enterYear;
    /**
     * 专业名称
     */
    private String name;
    /**
     * 学制
     */
    private String langthYear;
    /**
     * 是否结业
     */
    private int isFinish;

    //1对多，1个专业多个学生
    private List<Stuuser> stuuserList;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEnterYear() {
        return enterYear;
    }

    public void setEnterYear(String enterYear) {
        this.enterYear = enterYear;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLangthYear() {
        return langthYear;
    }

    public void setLangthYear(String langthYear) {
        this.langthYear = langthYear;
    }

    public int getIsFinish() {
        return isFinish;
    }

    public void setIsFinish(int isFinish) {
        this.isFinish = isFinish;
    }

    public List<Stuuser> getStuuserList() {
        return stuuserList;
    }

    public void setStuuserList(List<Stuuser> stuuserList) {
        this.stuuserList = stuuserList;
    }
}
