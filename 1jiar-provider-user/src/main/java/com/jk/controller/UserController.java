package com.jk.controller;

import com.jk.ConstantConf;
import com.jk.model.*;
import com.jk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Controller

public class UserController {

    @Autowired
    private UserService userService;

    @Resource
    private RedisTemplate<String,Object> redisTemplate;
    //短信验证
    @RequestMapping("duanxinyanzheng")
    @ResponseBody
    public String duanxinyanzheng(String login,HttpServletRequest request) {
        Object object = redisTemplate.opsForValue().get(ConstantConf.STRINGDXYZ+"Verification");
        if (object!=null) {
            return "sss";
        }
        double random = Math.random();
        int Verification = (int)((random*9+1)*100000);

        redisTemplate.opsForValue().set(ConstantConf.STRINGDXYZ+"Verification", Verification, ConstantConf.INTEGERDXYZTIME, TimeUnit.SECONDS);

        String  va = "";
        va+=Verification;
        System.out.println(va);
        return va;
    }
    @Autowired
    private UserService userservice;
    //手机验证码
    @RequestMapping("phoneVerification/{login}")
    @ResponseBody
    public Login phoneVerification(@RequestParam("login")String login) {
        Login qlogin  =  userservice.phoneVerification(login);
        return qlogin;
    }

    /*@RequestMapping("phoneVerificat/{login}")
    @ResponseBody
    public Login phoneVerificat(@RequestParam("login")String login) {
        Login qlogin  =  userservice.phoneVerificat(login);
        return qlogin;
    }*/

    @RequestMapping("queryhouse")
    @ResponseBody
    public HashMap<String, Object> findHousePage(@RequestParam Integer page, @RequestParam Integer rows, @RequestBody House house){
        HashMap<String, Object> housePage=null;
        // List<Object> range = redisTemplate.opsForList().range(CommonConf.SMS_QUERYHOUSE+"_"+page+"_"+rows, 0, -1);
        //if(range == null || range.size()<=0){
        housePage = userservice.findHousePage(page, rows, house);
        //  redisTemplate.opsForList().leftPush(CommonConf.SMS_QUERYHOUSE+"_"+page+"_"+rows, housePage);
        // redisTemplate.expire(CommonConf.SMS_QUERYHOUSE+"_"+page+"_"+rows,1, TimeUnit.MINUTES);

        // }else{
        //   housePage = (HashMap<String, Object>) range.get(0);
        //  }
        return  housePage;

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
     * 表查询
     */
    @RequestMapping("qureyResume")
    @ResponseBody
    public HashMap<String, Object> qureyResume(@RequestParam Integer page, @RequestParam Integer rows, @RequestBody Login login){
        HashMap<String, Object> housePage=null;
        housePage = userservice.qureyResume(page, rows, login);
        return  housePage;

    }
    /**
     * 注册
     */
    @RequestMapping("savelogin")
    @ResponseBody
    public Integer savelogin(@RequestBody Login login){
      return   userService.savelogin(login);
    }

    /**
     * 登录
     */
    @ResponseBody
    @RequestMapping("login")
    public String login(@RequestBody Login login) {
        return userService.login(login);
    }


    @RequestMapping("selectjiaoyid")
    @ResponseBody
    public List<jiaoyid> selectjiaoyid(){
        return userService.selectjiaoyid();
    }
    @RequestMapping("selecthengyid")
    @ResponseBody
    public List<hengyid> selecthengyid(){
        return userService.selecthengyid();
    }
    @RequestMapping("selectshuozaiid")
    @ResponseBody
    public List<shuozaiid> selectshuozaiid(){
        return userService.selectshuozaiid();
    }
    @RequestMapping("shuosiname")
    @ResponseBody
    public List<shuosiname> shuosiname(@RequestParam Integer pid){
        return userService.shuosiname(pid);
    }


    @RequestMapping("jiaxidname")
    @ResponseBody
    public List<jiaxid> jiaxidname(){
        return userService.jiaxidname();
    }

    @RequestMapping("jiaoxidname")
    @ResponseBody
    public List<jiaoxi> jiaoxidname(@RequestParam Integer pid){
        return userService.jiaoxidname(pid);

    }

    @RequestMapping("addOwner")
    @ResponseBody
    public void addOwner(@RequestBody Login resume){
        userService.addOwner(resume);
    }

    @RequestMapping("deleteuser")
    @ResponseBody
    public void deleteuser(Integer id) {
         userService.deleteuser(id);
    }

    @RequestMapping("deleteshouc")
    @ResponseBody
    public void deleteshouc(Integer houseId) {
        userService.deleteshouc(houseId);
    }

    @RequestMapping("zenghe")
    @ResponseBody
    public List<zenghe> zenghe(){
        return userService.zenghe();
    }


    @RequestMapping("inituserphone")
    @ResponseBody
    public List<Login> inituserphone(){
        return userService.inituserphone();
    }

}
