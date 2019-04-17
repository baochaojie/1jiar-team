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

    @PostMapping("findTree")
    List<Tree> findTree();

    /**
     *
     * @param login
     * @return

    @RequestMapping("dengl")
    Boolean dengl(Login login);

    @RequestMapping("login1")
    String login1(@RequestBody Login login);
     */
}
