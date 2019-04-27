package com.jk.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class Login implements Serializable {
    private static final long serialVersionUID = 181586574470530193L;
    private Integer id;

    private String name;

    private String phoneNum;

    private String login;

    private String password;

    private String loginimg;
    private String namea;
    private Integer jiaxid;
    private Integer jiaoxid;
    private Integer xingb;
    private Integer aihao;
    private Integer jiaoyid;
    private Integer hengyid;
    private Integer shuozaisiid;
    private Integer shuozaiid;
    private String jiaxidname;
    private String jiaoyidname;
    private String hengyidname;
    private String shuozaiidname;
    private String jiaoxidname;
    private String shuosiname;

}
