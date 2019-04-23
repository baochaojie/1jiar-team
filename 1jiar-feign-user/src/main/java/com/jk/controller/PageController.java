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

    @RequestMapping("addList")
    public String addList(){
        return "addList";
    }
    @RequestMapping("shouc")
    public String shouc(){
        return "shouc";
    }
    @RequestMapping("loginsj")
    public String loginsj(){
        return "loginsj";
    }
    @RequestMapping("shouye")
    public String shouye(){
        return "shouye";
    }
    @RequestMapping("zenghe")
    public String zenghe(){
        return "zenghe";
    }


    @RequestMapping("quangbu")
    public String addList(String url){
        return url;
    }

}
