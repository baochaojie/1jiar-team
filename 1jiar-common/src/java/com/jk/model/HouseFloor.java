package com.jk.model;

import lombok.Data;

import java.io.Serializable;

@Data
//楼层类型表
public class HouseFloor implements Serializable {

    private static final long serialVersionUID = 8170150780338632482L;
    private Integer houseFloorTypeId;

    private String floorName;
}
