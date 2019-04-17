package com.jk.controller;

import com.jk.model.AgentBean;
import com.jk.model.AreaBean;
import com.jk.service.AgentService;
import com.jk.utils.OSSClientUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

@Controller
public class AgentController {
    @Autowired
    private AgentService agentService;
   //跳转到查询经济人的页面
    @RequestMapping("toAgent")
    public String toAgent(){
        return "toAgent";
    }
    //新增经济人
    @RequestMapping("saveAgent")
    @ResponseBody
    public void saveAgent(AgentBean agentBean){
        agentBean.setArgentImg(agentImg);
        agentService.saveAgent(agentBean);
    }
    //跳转到经济人新增的页面
    @RequestMapping("toAddAgent")
    public String toAddAgent(){
        return "toAddAgent";
    }
   //查询经济人
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
    String agentImg ="";
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
        agentImg=split[0];
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
}
