package com.jk.model;

import lombok.Data;

import java.io.Serializable;

@Data
//房龄表
public class HouseAge implements Serializable {

    private static final long serialVersionUID = 7733600340296985952L;
    private Integer houseAgeId;

    private String ageName;

}
