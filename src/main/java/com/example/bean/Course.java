package com.example.bean;

/**
 * Created by LiQian_Nice on 2018/2/19
 *
 * 与课程表对应的实体类
 */
public class Course {

    /**
     * 课程编号
     */
    private String id;
    /**
     * 课程名称
     */
    private String name;
    /**
     * 上课时间
     */
    private String schooltime;
    /**
     * 上课地点
     */
    private String addr;
    /**
     * 课程学分
     */
    private String credit;
    /**
     * 课程介绍
     */
    private String courseInfo;
    /**
     * 授课老师
     */
    private String teacherName;
    /**
     * 教师介绍
     */
    private String teacherInfo;
    /**
     * 是否结束
     */
    private String isFinish;
    /**
     * 专业编号
     */
    private String specialtyId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSchooltime() {
        return schooltime;
    }

    public void setSchooltime(String schooltime) {
        this.schooltime = schooltime;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getCredit() {
        return credit;
    }

    public void setCredit(String credit) {
        this.credit = credit;
    }

    public String getCourseInfo() {
        return courseInfo;
    }

    public void setCourseInfo(String courseInfo) {
        this.courseInfo = courseInfo;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getTeacherInfo() {
        return teacherInfo;
    }

    public void setTeacherInfo(String teacherInfo) {
        this.teacherInfo = teacherInfo;
    }

    public String getIsFinish() {
        return isFinish;
    }

    public void setIsFinish(String isFinish) {
        this.isFinish = isFinish;
    }

    public String getSpecialtyId() {
        return specialtyId;
    }

    public void setSpecialtyId(String specialtyId) {
        this.specialtyId = specialtyId;
    }
}
