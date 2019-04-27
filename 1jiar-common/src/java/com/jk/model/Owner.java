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
    private String name;    //用户名字
    private String phoneNum;    //用户手机号

    private String ownerSell;

    private String ownerState="1";  //审核状态： 1是待审核，2是审核通过，3是未通过审核

}
