package com.jk.model;

import lombok.Data;

import java.io.Serializable;

@Data
//房屋类型表 如：别墅类，商业类
public class HouseUse implements Serializable {

    private static final long serialVersionUID = 7748312874452235275L;
    private Integer houseUseId;

    private String useName;
}
