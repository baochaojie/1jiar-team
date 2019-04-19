package com.jk.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class DlrldTypeBean implements Serializable {

    private Integer dlrldtyId;

    private String dlrldName;

    private Integer prizeId;

    private String awardImg;

    private String integName;
}
