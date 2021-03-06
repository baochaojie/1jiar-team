package com.jk.service;

import com.jk.model.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;

@FeignClient("1jiar-provider-user")
public interface UserService {


    @RequestMapping("findTree")
    List<Tree> findTree();

    @RequestMapping("savelogin")
    Integer savelogin(@RequestBody Login login);

    @PostMapping("login")
    @ResponseBody
    String login(@RequestBody Login login);

    @RequestMapping("phoneVerification/{login}")
    @ResponseBody
    Login phoneVerification(@RequestParam("login") String login);

    @PostMapping("selectjiaoyid")
    List<jiaoyid> selectjiaoyid();

    @PostMapping("selecthengyid")
    List<hengyid> selecthengyid();

    @PostMapping("selectshuozaiid")
    List<shuozaiid> selectshuozaiid();

    @RequestMapping("shuosiname")
    @ResponseBody
    List<shuosiname> shuosiname(@RequestParam Integer pid);

    @PostMapping("jiaxidname")
    List<jiaxid> jiaxidname();

    @RequestMapping("jiaoxidname")
    @ResponseBody
    List<jiaoxi> jiaoxidname(@RequestParam Integer pid);

    @RequestMapping("addOwner")
    @ResponseBody
    void updatewner(@RequestBody Login resume);

    @GetMapping("deleteuser")
    void deleteuser(@RequestParam Integer id);

    @RequestMapping("zenghe")
    List<zenghe> zenghe();

   /* @RequestMapping("phoneVerificat/{login}")
    @ResponseBody
    Login phoneVerificat(@RequestParam("login")String login);
*/
    @RequestMapping("queryhouse")
    @ResponseBody
    HashMap<String, Object> findHousePage(@RequestParam Integer page, @RequestParam Integer rows, @RequestBody House house);

    @PostMapping("inituserphone")
    List<Login> inituserphone();

    @GetMapping("deleteshouc")
    void deleteshouc(@RequestParam Integer houseId);

    @PostMapping("qureyResume")
    HashMap<String, Object> qureyResume(@RequestParam Integer page, @RequestParam Integer rows, @RequestBody Login login);

    @RequestMapping("queryhunx")
    Login queryhunx(@RequestParam Integer id);
}
