package com.example.bean;

/**
 * Created by LiQian_Nice on 2018/2/19
 *
 * 与学生的课程对应的实体类
 */
public class Stucourse {
    /**
     * 学生编号
     */
    private String stuID;
    /**
     * 课程编号
     */
    private String courseID;
    /**
     * 主键
     */
    private String id;

    public String getStuID() {
        return stuID;
    }

    public void setStuID(String stuID) {
        this.stuID = stuID;
    }

    public String getCourseID() {
        return courseID;
    }

    public void setCourseID(String courseID) {
        this.courseID = courseID;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
