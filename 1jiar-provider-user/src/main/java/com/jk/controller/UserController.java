package com.jk.controller;

import com.jk.model.Login;
import com.jk.model.Resume;
import com.jk.model.Tree;
import com.jk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;

@Controller

public class UserController {

    @Autowired
    private UserService userService;


    /**
     * 注册



//登录
    @ResponseBody
    @RequestMapping("login")
    public String login1(@RequestBody Login login, HttpSession session) {

        return userService.login(login,session);
    }

    @RequestMapping("login1")
    @ResponseBody
    public HashMap<String,Object> login1(@RequestBody Login login, @RequestParam String imgcode, HttpServletRequest request){
        return userService.login1(login,imgcode,request);
    }
/
     */
}
