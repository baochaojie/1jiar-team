package com.jk.model;

import lombok.Data;

@Data
public class Owner {

    private Integer ownerId;

    private Integer ownerCityId;

    private String ownerXiaoqu;

    private String ownerSiteDong;

    private String ownerSiteDanyuan;

    private String ownerSiteMenpai;

    private Integer ownerUserId;    //关联一张用户表

    private String ownerSell;

    private String ownerState;
}
