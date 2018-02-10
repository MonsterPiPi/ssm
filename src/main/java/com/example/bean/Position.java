package com.example.bean;

/**
 * Created by LiQian_Nice on 2018/2/10
 *
 * 与职位表对应的实体类
 */
public class Position {

    /**
     * 主键
     */
    private String id;
    /**
     * 职位名称
     */
    private String name;
    /**
     * 职位描述
     */
    private String description;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
