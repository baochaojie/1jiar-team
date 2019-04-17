package com.jk.controller;

import com.jk.mapper.AgentMapper;
import com.jk.model.AgentBean;
import com.jk.utils.OSSClientUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

@Controller
public class AgentController {

    @Autowired
    private AgentMapper agentMapper;
    //查询经济人
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
    //新增经济人
    @RequestMapping("saveAgent")
    @ResponseBody
    public void saveAgent(@RequestBody AgentBean agentBean){
        agentMapper.saveAgent(agentBean);
    }
    //查询地区
    @RequestMapping("findRegion/{id}")
    @ResponseBody
    public List<AgentBean> findRegion(@PathVariable("id") Integer id){
        return agentMapper.findRegion(id);
    }
    //经济人回显
    @RequestMapping("findAgentInfoById/{agentId}")
    @ResponseBody
    public AgentBean findAgentInfoById(@PathVariable("agentId") Integer agentId){
        return agentMapper.findAgentInfoById(agentId);
    }
    //经济人删除
    @RequestMapping("deleteAgent/{ids}")
    @ResponseBody
    public Boolean deleteAgent(@PathVariable("ids") Integer[]ids){
        int count = agentMapper.deleteAgent(ids);
        if(count>0){
            return true;
        }else{
            return false;
        }
    }
}
