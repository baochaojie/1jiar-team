package com.jk.model;

import lombok.Data;

import java.io.Serializable;

public class DlrldIntegrelBean implements Serializable {

    private Integer dltypeid;

    private String dltypeName;

    private String dltymoney;

    public Integer getDltypeid() {
        return dltypeid;
    }

    public void setDltypeid(Integer dltypeid) {
        this.dltypeid = dltypeid;
    }

    public String getDltypeName() {
        return dltypeName;
    }

    public void setDltypeName(String dltypeName) {
        this.dltypeName = dltypeName;
    }

    public String getDltymoney() {
        return dltymoney;
    }

    public void setDltymoney(String dltymoney) {
        this.dltymoney = dltymoney;
    }
}
