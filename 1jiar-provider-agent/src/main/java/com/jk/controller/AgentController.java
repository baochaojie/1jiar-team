package com.jk.controller;

import com.jk.mapper.AgentMapper;
import com.jk.model.AgentBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@Controller
public class AgentController {

    @Autowired
    private AgentMapper agentMapper;

    @RequestMapping("findAgent")
    @ResponseBody
    public HashMap<String,Object> findAgent(@RequestParam Integer page, @RequestParam Integer rows,@RequestBody AgentBean agentBean){
        System.out.println(agentBean);
        HashMap<String, Object> map = new HashMap<>();
        Integer total = agentMapper.findCountAgent(agentBean);
        Integer start = (page-1)*rows;
        List<AgentBean> list = agentMapper.findAgent(start,rows,agentBean);
        map.put("total",total);
        map.put("rows",list);
        return map;
    }
    @RequestMapping("saveAgent")
    @ResponseBody
    public void saveAgent(@RequestBody AgentBean agentBean){
        agentMapper.saveAgent(agentBean);
    }
    @RequestMapping("findRegion/{id}")
    @ResponseBody
    public List<AgentBean> findRegion(@PathVariable("id") Integer id){
        return agentMapper.findRegion(id);
    }
}
