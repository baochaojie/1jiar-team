package com.jk.model;

import java.io.Serializable;
//房屋特色表
public class houseFeature implements Serializable {
    private static final long serialVersionUID = -6388095264780712945L;
    private  Integer houseTeSeId;
    private  String  houseTeSeName;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getHouseTeSeId() {
        return houseTeSeId;
    }

    public void setHouseTeSeId(Integer houseTeSeId) {
        this.houseTeSeId = houseTeSeId;
    }

    public String getHouseTeSeName() {
        return houseTeSeName;
    }

    public void setHouseTeSeName(String houseTeSeName) {
        this.houseTeSeName = houseTeSeName;
    }
}
