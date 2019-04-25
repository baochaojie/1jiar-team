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
   /* @RequestMapping("phoneVerificat")
    @ResponseBody
    public Integer phoneVerificat(String login,String password ,HttpServletRequest request) {
        System.out.println(login);
        System.out.println(password);
        HttpSession session = request.getSession();
        String attribute = session.getAttribute("password").toString();
        System.out.println(attribute);
        //String attribute = redisTemplate.opsForValue().get(ConstantConf.STRINGDXYZ+"Verification").toString();
        if (!attribute.equals(password)) {
            return 2;
        }
        Login login1  =  userService.phoneVerificat(login);
        if (login1==null) {
            return 1;
        }

        session.setAttribute(session.getId(), login1);
        return 0;
    }*/
    @RequestMapping("qureyResume")
    @ResponseBody

    public HashMap<String, Object> qureyResume(Integer page, Integer rows, Login login ){

        return userService.qureyResume(page,rows,login);
    }

    @RequestMapping("inituserphone")
    @ResponseBody
    public List<Login> inituserphone(){
        return userService.inituserphone();
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
        System.out.println("大声大声道");
        return  userService.savelogin(login);
    }

    /**
     * 登录
     */
    @RequestMapping("login")
    @ResponseBody
    public String login(Login login,HttpServletRequest request) {
        String login1 = userService.login(login);
        HttpSession session1 = request.getSession();
        System.out.println(session1.getId());
        String login2 = login.getLogin();
        userService.phoneVerification(login2);
        if (login1.equals("0")){
            redisTemplate.opsForValue().set(session1.getId(),login2);
            redisTemplate.expire(session1.getId(),30 , TimeUnit.MINUTES);
        }
        return login1;
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
    public void addOwner(Login resume){
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

    @RequestMapping("deleteshouc")
    @ResponseBody
    public void deleteshouc(Integer houseId) {
        userService.deleteshouc(houseId);
    }
    /**
     * 整合
     */
    @RequestMapping("zenghe")
    @ResponseBody
    public List<zenghe> zenghe(){
        return userService.zenghe();
    }

    @RequestMapping("queryhouse")
    @ResponseBody
    public HashMap<String, Object> findUserPage(Integer page, Integer rows, House house ){

        return userService.findHousePage(page,rows,house);
    }
    @RequestMapping("inituser")
    @ResponseBody
    public String findUserPage(HttpServletRequest request){
        HttpSession session = request.getSession();
        System.out.println(session.getId());
        Boolean aBoolean = redisTemplate.hasKey(session.getId());
        if (aBoolean){
            //1说明以登入
            return session.getId();
        }
        //2说明没登入
        return "";
    }

}
