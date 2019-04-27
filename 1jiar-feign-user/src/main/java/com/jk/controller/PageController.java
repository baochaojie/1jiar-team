package com.jk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("page")
public class PageController {

    /**
     * 个人中心查询
     */
    @RequestMapping("user")
    public  String stue(){
        System.out.println("dasda");
        return "userlist";
    }
    /**
     * 个人中心树
     */
    @RequestMapping("tree")
    public  String aaa(){
        return "treelist";
    }
    /**
     * 普通登录
     */
    @RequestMapping("login")
    public String login(){
        return "login";
    }

    @RequestMapping("hhlogin")
    public String hhlogin(){
        return "hhlogin";
    }
    /**
     * 注册
     */
    @RequestMapping("zhuc")
    public String dengl(){
        return "zhuc";
    }
    /**
     * 个人用户新增
     */
    @RequestMapping("addList")
    public String addList(){
        return "addList";
    }
    /**
     * 个人收藏
     */
    @RequestMapping("shouc")
    public String shouc(){
        return "shouc";
    }
    /**
     * 快捷登录
     */
    @RequestMapping("loginsj")
    public String loginsj(){
        return "loginsj";
    }

    @RequestMapping("hloginsj")
    public String hloginsj(){
        return "hloginsj";
    }
    /**
     * 主页
     */
    @RequestMapping("shouye")
    public String shouye(){
        return "shouye";
    }
    /**
     * 整合
     */
    @RequestMapping("zenghe")
    public String zenghe(){
        return "zenghe";
    }

    /**
     * url
     */
        @RequestMapping("quangbu")
    public String addList(String url){
        return url;
    }

}
