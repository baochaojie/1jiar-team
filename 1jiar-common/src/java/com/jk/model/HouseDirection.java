package com.jk.model;

import lombok.Data;

import java.io.Serializable;

@Data
//楼房朝向表
public class HouseDirection implements Serializable {

    private static final long serialVersionUID = 8551022764169547110L;
    private Integer houseDirectionId;

    private String otName;
}
