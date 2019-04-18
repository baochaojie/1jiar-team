package com.jk.model;

import java.io.Serializable;
//租房方式 1整租 2 合租
public class HouseZuType implements Serializable {
    private static final long serialVersionUID = 5020741111652310633L;
    private  Integer ZuTypeid;
    private  String  ZuTypeName;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getZuTypeid() {
        return ZuTypeid;
    }

    public void setZuTypeid(Integer zuTypeid) {
        ZuTypeid = zuTypeid;
    }

    public String getZuTypeName() {
        return ZuTypeName;
    }

    public void setZuTypeName(String zuTypeName) {
        ZuTypeName = zuTypeName;
    }
}
