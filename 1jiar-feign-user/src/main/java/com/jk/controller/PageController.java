package com.jk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("page")
public class PageController {

    @RequestMapping("user")
    public  String stue(){
        System.out.println("dasda");
        return "userlist";
    }

    @RequestMapping("tree")
    public  String aaa(){
        return "treelist";
    }

    @RequestMapping("login")
    public String login(){
        return "login";
    }

    @RequestMapping("zhuc")
    public String dengl(){
        return "zhuc";
    }

    @RequestMapping("kjlogin")
    public String login1(){
        return "login1";
    }

    @RequestMapping("addList")
    public String addList(){
        return "addList";
    }
    @RequestMapping("quangbu")
    public String addList(String url){
        return url;
    }

}
