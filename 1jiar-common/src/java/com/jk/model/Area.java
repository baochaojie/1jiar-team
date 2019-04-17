package com.jk.model;

import java.io.Serializable;
//地区表
public class Area implements Serializable {
    private static final long serialVersionUID = 6752754646090151917L;
    private Integer id;//地区id
    private String name;//地区名
    private Integer pid;//地区pid

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }
}
