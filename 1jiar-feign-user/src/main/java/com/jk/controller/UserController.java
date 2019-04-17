package com.jk.controller;

import com.jk.model.Login;
import com.jk.model.Resume;
import com.jk.model.Tree;
import com.jk.service.UserService;
import org.apache.tomcat.websocket.AuthenticationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;

@Controller

public class UserController {

    @Autowired
    private UserService userService;


    /**
     * 查询
     */

    @RequestMapping("qureyResume")
    @ResponseBody
    public List<Resume> qureyResume(){
        return userService.qureyResume();
    }


    /**
     * 左侧树
     */

    @RequestMapping("findTree")
    @ResponseBody
    public List<Tree> findTree(){
        return userService.findTree();
    }


    /**
     * 注册


    @ResponseBody
    @RequestMapping("dengl")
    public Boolean dengl(Login login){
       System.out.println("哈哈");
        try {
         return userService.dengl(login);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    //登录
    @ResponseBody
    @RequestMapping("login1")
    public String login1(Login login) {
    System.out.println("哈哈");
        return userService.login1(login);
    }

     */
}
