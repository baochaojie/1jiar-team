package com.jk.model;

import java.io.Serializable;
//地铁表
public class Subway implements Serializable {
    private static final long serialVersionUID = 5264220902485585247L;
    private  Integer  subwayId;//地铁id
    private  String  subwayName;//地铁名称
    private  Integer  subwayPid;//地铁pid

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getSubwayId() {
        return subwayId;
    }

    public void setSubwayId(Integer subwayId) {
        this.subwayId = subwayId;
    }

    public String getSubwayName() {
        return subwayName;
    }

    public void setSubwayName(String subwayName) {
        this.subwayName = subwayName;
    }

    public Integer getSubwayPid() {
        return subwayPid;
    }

    public void setSubwayPid(Integer subwayPid) {
        this.subwayPid = subwayPid;
    }
}
