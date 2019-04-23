package com.jk.model;

import java.io.Serializable;

public class LabelBean implements Serializable {
    private static final long serialVersionUID = 4136310465792550128L;
    private Integer labelId;
    private String labelName;

    public Integer getLabelId() {
        return labelId;
    }

    public void setLabelId(Integer labelId) {
        this.labelId = labelId;
    }

    public String getLabelName() {
        return labelName;
    }

    public void setLabelName(String labelName) {
        this.labelName = labelName;
    }

    @Override
    public String toString() {
        return "LabelBean{" +
                "labelId=" + labelId +
                ", labelName='" + labelName + '\'' +
                '}';
    }
}
