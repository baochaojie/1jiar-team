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


}
