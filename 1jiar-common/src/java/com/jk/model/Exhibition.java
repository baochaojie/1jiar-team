package com.jk.model;

public class Exhibition {
    private Integer id;
    private Integer areaId;
    private Integer agentId;
    private Integer volume;
    private Integer daiKanliang;
    private String village;
    private String areaName;

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    public Integer getAgentId() {
        return agentId;
    }

    public void setAgentId(Integer agentId) {
        this.agentId = agentId;
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

    public String getVillage() {
        return village;
    }

    public void setVillage(String village) {
        this.village = village;
    }

    @Override
    public String toString() {
        return "Exhibition{" +
                "id=" + id +
                ", areaId=" + areaId +
                ", agentId=" + agentId +
                ", volume=" + volume +
                ", daiKanliang=" + daiKanliang +
                ", village='" + village + '\'' +
                ", areaName='" + areaName + '\'' +
                '}';
    }
}
