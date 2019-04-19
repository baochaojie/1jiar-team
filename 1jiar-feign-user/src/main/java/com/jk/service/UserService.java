package com.jk.service;

import com.jk.model.Login;
import com.jk.model.Resume;
import com.jk.model.Tree;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;

@FeignClient("1jiar-provider-user")
public interface UserService {

    @PostMapping("qureyResume")
    List<Resume> qureyResume();

    @RequestMapping("findTree")
    List<Tree> findTree();

    @RequestMapping("savelogin")
    Integer savelogin(@RequestBody Login login);

    @PostMapping("login")
    @ResponseBody
    String login(@RequestBody Login login);



}
