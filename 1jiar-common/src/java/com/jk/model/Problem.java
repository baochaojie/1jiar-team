package com.jk.model;

public class Problem {
    private Integer id;//主键
    private Integer agentId;//关联经纪人id
    private String problem;//一句话描述您的疑问（必填）
    private String proDescription;//问题描述
    private Integer proType;//问题分类

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAgentId() {
        return agentId;
    }

    public void setAgentId(Integer agentId) {
        this.agentId = agentId;
    }

    public String getProblem() {
        return problem;
    }

    public void setProblem(String problem) {
        this.problem = problem;
    }

    public String getProDescription() {
        return proDescription;
    }

    public void setProDescription(String proDescription) {
        this.proDescription = proDescription;
    }

    public Integer getProType() {
        return proType;
    }

    public void setProType(Integer proType) {
        this.proType = proType;
    }

    @Override
    public String toString() {
        return "Problem{" +
                "id=" + id +
                ", agentId=" + agentId +
                ", problem='" + problem + '\'' +
                ", proDescription='" + proDescription + '\'' +
                ", proType=" + proType +
                '}';
    }
}
