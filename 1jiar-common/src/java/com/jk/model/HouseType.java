package com.jk.model;

import lombok.Data;

import java.io.Serializable;

@Data
//楼房几间房类型表  如：一室，二室
public class HouseType implements Serializable {

    private static final long serialVersionUID = 837842205120449346L;
    private Integer houseTypeId;

    private String houseName;
}
