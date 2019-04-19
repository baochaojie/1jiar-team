package com.jk.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class DlrldBean implements Serializable {
    private Integer dlrIdId;

    private Integer integralAdd;

    private Integer houseId;

    private Integer prizeTypeid;

    private String takeTime;

    private Integer dlrldtyId;

    private Integer stateId;

    private String loimg;

    private String userName;

    //临时字段
    private String dltyname ;

    private String dley ;

    private String tame ;

    private String dllid ;

    private String dllname ;

    private String awardImg ;

}
