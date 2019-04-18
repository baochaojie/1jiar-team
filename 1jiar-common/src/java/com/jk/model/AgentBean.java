package com.jk.model;

public class AgentBean {
    private Integer agentId;//经纪人id
    private String agentName;//经济人名称
    private String agentJob;//经济人职位
    private Integer region;//地区
    private String detail;//经纪人简介
    private Integer street;//街道
    private String agentPhone;//经济人电话
    private String argentImg;//经济人头像
    private Double score;//经济人评分
    //添加临时字段
    private String regionName;
    private String streetName;

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
                ", regionName='" + regionName + '\'' +
                ", streetName='" + streetName + '\'' +
                '}';
    }
}
