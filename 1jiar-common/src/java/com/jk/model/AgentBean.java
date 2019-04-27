package com.jk.model;

import java.io.Serializable;

public class AgentBean implements Serializable {
    private static final long serialVersionUID = -6487977238499462756L;
    private Integer agentId;//经纪人id
    private String agentName;//经济人名称
    private String agentJob;//经济人职位
    private Integer region;//地区
    private String detail;//经纪人简介
    private Integer street;//街道
    private String agentPhone;//经济人电话
    private String argentImg;//经济人头像
    private Double score;//经济人评分
    private String store;//经纪人所属店铺
    private String agentYears;//经纪人工作年限
    private Integer houseId;//关联房子id
    private String achievement;//个人成绩
    private String labelId;//关联标签id
    //添加临时字段
    private String regionName;//区域名称
    private String streetName;//街道名称
    private Integer commentCount;//评论条数
    private String houseName;//小区
    private String labelName;//标签
    private Integer exhiId;//关联看房子
    private Integer volume;//成交量
    private Integer daiKanliang;//带看量
    private String village;//小区名称

    public String getVillage() {
        return village;
    }

    public void setVillage(String village) {
        this.village = village;
    }

    public Integer getExhiId() {
        return exhiId;
    }

    public void setExhiId(Integer exhiId) {
        this.exhiId = exhiId;
    }

    public Integer getVolume() {
        return volume;
    }

    public void setVolume(Integer volume) {
        this.volume = volume;
    }

    public Integer getDaiKanliang() {
        return daiKanliang;
    }

    public void setDaiKanliang(Integer daiKanliang) {
        this.daiKanliang = daiKanliang;
    }

    public String getHouseName() {
        return houseName;
    }

    public void setHouseName(String houseName) {
        this.houseName = houseName;
    }

    public String getLabelName() {
        return labelName;
    }

    public void setLabelName(String labelName) {
        this.labelName = labelName;
    }

    public String getAchievement() {
        return achievement;
    }

    public void setAchievement(String achievement) {
        this.achievement = achievement;
    }

    public String getLabelId() {
        return labelId;
    }

    public void setLabelId(String labelId) {
        this.labelId = labelId;
    }

    public Integer getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(Integer commentCount) {
        this.commentCount = commentCount;
    }

    public String getStore() {
        return store;
    }

    public void setStore(String store) {
        this.store = store;
    }

    public String getAgentYears() {
        return agentYears;
    }

    public void setAgentYears(String agentYears) {
        this.agentYears = agentYears;
    }

    public Integer getHouseId() {
        return houseId;
    }

    public void setHouseId(Integer houseId) {
        this.houseId = houseId;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public Integer getAgentId() {
        return agentId;
    }

    public void setAgentId(Integer agentId) {
        this.agentId = agentId;
    }

    public String getAgentName() {
        return agentName;
    }

    public void setAgentName(String agentName) {
        this.agentName = agentName;
    }

    public String getAgentJob() {
        return agentJob;
    }

    public void setAgentJob(String agentJob) {
        this.agentJob = agentJob;
    }

    public Integer getRegion() {
        return region;
    }

    public void setRegion(Integer region) {
        this.region = region;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Integer getStreet() {
        return street;
    }

    public void setStreet(Integer street) {
        this.street = street;
    }

    public String getAgentPhone() {
        return agentPhone;
    }

    public void setAgentPhone(String agentPhone) {
        this.agentPhone = agentPhone;
    }

    public String getArgentImg() {
        return argentImg;
    }

    public void setArgentImg(String argentImg) {
        this.argentImg = argentImg;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "AgentBean{" +
                "agentId=" + agentId +
                ", agentName='" + agentName + '\'' +
                ", agentJob='" + agentJob + '\'' +
                ", region=" + region +
                ", detail='" + detail + '\'' +
                ", street=" + street +
                ", agentPhone='" + agentPhone + '\'' +
                ", argentImg='" + argentImg + '\'' +
                ", score=" + score +
                ", store='" + store + '\'' +
                ", agentYears='" + agentYears + '\'' +
                ", houseId=" + houseId +
                ", achievement='" + achievement + '\'' +
                ", labelId='" + labelId + '\'' +
                ", regionName='" + regionName + '\'' +
                ", streetName='" + streetName + '\'' +
                ", commentCount=" + commentCount +
                ", houseName='" + houseName + '\'' +
                ", labelName='" + labelName + '\'' +
                ", exhiId=" + exhiId +
                ", volume=" + volume +
                ", daiKanliang=" + daiKanliang +
                ", village='" + village + '\'' +
                '}';
    }
}

