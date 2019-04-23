package com.jk.controller;

import com.jk.ConstantConf;
import com.jk.model.*;
import com.jk.service.UserService;
import com.jk.utils.HttpClientUtil;
import com.jk.utils.Md5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Controller

public class UserController {

    @Autowired
    private UserService userService;


    @Resource
    private RedisTemplate<String,Object> redisTemplate;

    @RequestMapping("duanxinyanzheng")
    @ResponseBody
    public String duanxinyanzheng(String login,HttpServletRequest request) {


        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("accountSid", ConstantConf.STRINGW);
        hashMap.put("to", login);
        String format = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        hashMap.put("timestamp", format);
        String md532 = Md5Util.getMd532(ConstantConf.STRINGW+ConstantConf.STRINGE+format);
        hashMap.put("sig", md532);
        hashMap.put("templateid", ConstantConf.STRINGT);
        Object object = redisTemplate.opsForValue().get(ConstantConf.STRINGDXYZ+"Verification");
        if (object!=null) {
            return "sss";
        }
        double random = Math.random();
        int Verification = (int)((random*9+1)*100000);
        HttpSession session = request.getSession();
        session.setAttribute("Verification", Verification);
        redisTemplate.opsForValue().set(ConstantConf.STRINGDXYZ+"Verification", Verification, ConstantConf.INTEGERDXYZTIME, TimeUnit.SECONDS);
        hashMap.put("param", Verification);
        String post = HttpClientUtil.post(ConstantConf.STRINGR, hashMap);
        String  va = "";
        va+=Verification;
        System.out.println(va);
        return va;
    }

    @RequestMapping("phoneVerification")
    @ResponseBody
    public Integer phoneVerification(String login,String Verification ,HttpServletRequest request) {
        System.out.println(login);
        System.out.println(Verification);
        HttpSession session = request.getSession();
        String attribute = session.getAttribute("Verification").toString();
        System.out.println(attribute);
        //String attribute = redisTemplate.opsForValue().get(ConstantConf.STRINGDXYZ+"Verification").toString();
        if (!attribute.equals(Verification)) {
            return 2;//验证码不正确
        }
        Login login1  =  userService.phoneVerification(login);
        if (login1==null) {
            return 1;//此手机号未注册
        }

        session.setAttribute(session.getId(), login1);
        return 0;
    }

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
     */
    @RequestMapping("savelogin")
    @ResponseBody
    public Integer savelogin(Login login){
        return  userService.savelogin(login);
    }

    /**
     * 登录
     */
    @RequestMapping("login")
    @ResponseBody
    public String login(Login login){
        return userService.login(login);
    }


    /**
     * 教育
     */
    @RequestMapping("selectjiaoyid")
    @ResponseBody
    public List<jiaoyid> selectjiaoyid(){
        return userService.selectjiaoyid();
    }
    /**
     * 行业
     */
    @RequestMapping("selecthengyid")
    @ResponseBody
    public List<hengyid> selecthengyid(){
        return userService.selecthengyid();
    }
    /**
     * 地址市
     */
    @RequestMapping("selectshuozaiid")
    @ResponseBody
    public List<shuozaiid> selectshuozaiid(){
        return userService.selectshuozaiid();
    }
    /**
     * 地址省
     */
    @RequestMapping("shuosiname")
    @ResponseBody
    public List<shuosiname> shuosiname(Integer pid){
        return userService.shuosiname(pid);

    }
    /**
     * 地址市
     */
    @RequestMapping("jiaxidname")
    @ResponseBody
    public List<jiaxid> jiaxidname(){
        return userService.jiaxidname();
    }
    /**
     * 地址省
     */
    @RequestMapping("jiaoxidname")
    @ResponseBody
    public List<jiaoxi> jiaoxidname(Integer pid){
        return userService.jiaoxidname(pid);

    }
    /**
     * 新增
     */

    @RequestMapping("addOwner")
    @ResponseBody
    public void addOwner(Resume resume){
        userService.addOwner(resume);
    }
    /**
     * 删除
     */
    @RequestMapping("deleteuser")
    @ResponseBody
    public void deleteuser(Integer id) {
         userService.deleteuser(id);
    }

    /**
     * 整合
     */
    @RequestMapping("zenghe")
    @ResponseBody
    public List<zenghe> zenghe(){
        return userService.zenghe();
    }


}
