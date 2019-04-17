package com.jk.controller;

import com.jk.model.AgentBean;
import com.jk.model.AreaBean;
import com.jk.service.AgentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
    @RequestMapping("saveAgent")
    @ResponseBody
    public void saveAgent(AgentBean agentBean){
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
    @RequestMapping("findRegion")
    @ResponseBody
    public List<AreaBean> findRegion(Integer id){
        return agentService.findRegion(id);
    }
}
