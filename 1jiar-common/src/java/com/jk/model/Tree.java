package com.jk.model;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class Tree  {

    private Integer id;
    private String text;
    private Integer pid;
    private String href;
    private List<Tree> nodes;
    private Boolean selectable;


}
