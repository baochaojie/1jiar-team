package com.jk.controller;

import com.jk.model.*;
import com.jk.service.AgentService;
import com.jk.utils.OSSClientUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

@Controller
public class AgentController {
    @Autowired
    private AgentService agentService;
    @RequestMapping("quanbu")
    public String aa(String url){
        return url;
    }
   //跳转到查询经济人的页面
    @RequestMapping("toAgent")
    public String toAgent(){
        return "toAgent";
    }
    //新增经济人
    @RequestMapping("saveAgent")
    @ResponseBody
    public void saveAgent(AgentBean agentBean){
        agentBean.setArgentImg(argentImg);
        agentService.saveAgent(agentBean);
    }
    //跳转到经济人新增的页面
    @RequestMapping("toAddAgent")
    public String toAddAgent(){
        return "toAddAgent";
    }
   //分页查询经济人
    @RequestMapping("findAgent")
    @ResponseBody
    private HashMap<String,Object> findAgent( Integer page, Integer rows, AgentBean agentBean){
        System.out.println(agentBean);
        HashMap<String, Object> agent = agentService.findAgent(page, rows, agentBean);
        System.out.println(agent);
        return agent;
    }
    //查询地区
    @RequestMapping("findRegion")
    @ResponseBody
    public List<AreaBean> findRegion(Integer id){
        return agentService.findRegion(id);
    }
    //跳转到经济人修改的页面
    @RequestMapping("toEditAgent")
    public String toEditAgent(){
        return "toEditAgent";
    }
    //回显经纪人
    @RequestMapping("findAgentInfoById")
    @ResponseBody
    public AgentBean findAgentInfoById(Integer agentId){
        return agentService.findAgentInfoById(agentId);
    }
    String argentImg ="";
    //上传图片
    @RequestMapping("text")
    @ResponseBody
    public String uploadImg(MultipartFile file)throws IOException {
        if (file == null || file.getSize() <= 0) {
            throw new IOException("file不能为空");
        }
        OSSClientUtil ossClient=new OSSClientUtil();
        String name = ossClient.uploadImg2Oss(file);
        String imgUrl = ossClient.getImgUrl(name);
        String[] split = imgUrl.split("\\?");
        argentImg=split[0];
        return split[0];
    }
    @RequestMapping("src")
    public String src(){
        return "addbook";
    }
    //经纪人删除
    @RequestMapping("deleteAgent")
    @ResponseBody
    public boolean deleteAgent(Integer[]ids){
        System.out.println(ids);
        return agentService.deleteAgent(ids);
    }
    //查询评论
    @RequestMapping("findCommentCount")
    @ResponseBody
    public Integer findCommentCount(Integer agentId){
        Integer commentCount = agentService.findCommentCount(agentId);
        System.out.println("------------------"+commentCount);
        return commentCount;
    }
    //点击评论跳转到查询经济人的页面
    @RequestMapping("toAgent2")
    public String toAgent2(){
        return "toAgent2";
    }
    //查询小区
    @RequestMapping("findHouse")
    @ResponseBody
    public List<House> findHouse(){
        return agentService.findHouse();
    }


    //查询标签
    @RequestMapping("findLabel")
    @ResponseBody
    public List<LabelBean> findLabel(){
        return agentService.findLabel();
    }

    Integer initinterid = 0;
    @RequestMapping("toVillage")
     public String  toVillage(Integer agentId){
        initinterid=agentId;
        return  "toVillage";
    }
    @RequestMapping("toVillage2")
    public String  toVillage2(Integer agentId){
        initinterid=agentId;
        return  "toVillage2";
    }
    //查询成交小区
    @RequestMapping("findExhibition")
    @ResponseBody
    public List<Exhibition> findExhibition(Integer agentId){
        return agentService.findExhibition(agentId);
    }
    @RequestMapping("initagentId")
    @ResponseBody
    public Integer initagentId(){
        System.out.println(initinterid);
        return initinterid;
    }
    //查询树
    @RequestMapping("findGuide")
    @ResponseBody
    public List<DictionaryTable> findGuide() {
        List<DictionaryTable> list = agentService.findGuide();
        return list;
    }
    //新增问题
    @RequestMapping("addProblemInfoById")
    @ResponseBody
    public void addProblemInfoById(Problem problem){
        agentService.addProblemInfoById(problem);
    }
    @RequestMapping("toAddProblem")
    public String toAddProblem(){
        return "toAddProblem";
    }
    //查询树
    @RequestMapping("findProblem")
    @ResponseBody
    public List<Problem> findProblem() {
        List<Problem> list = agentService.findProblem();
        return list;
    }
    @RequestMapping("findEcharts")
    @ResponseBody
    public List<House> findEcharts(){
        System.out.println(1234);
        return agentService.findEcharts();
    }
}
