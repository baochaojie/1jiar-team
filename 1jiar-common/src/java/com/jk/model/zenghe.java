package com.jk.model;

import lombok.Data;

import java.util.List;

@Data
public class zenghe {

    private Integer id;
    private String text;
    private Integer pid;
    private String href;
    private List<zenghe> nodes;
    private Boolean selectable;


}
