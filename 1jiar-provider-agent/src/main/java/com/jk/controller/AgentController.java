package com.jk.controller;

import com.jk.mapper.AgentMapper;
import com.jk.model.AgentBean;
import com.jk.model.House;
import com.jk.model.LabelBean;
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

    //查询评论
    @RequestMapping
    @ResponseBody
    public Integer findCommentCount(@RequestParam Integer agentId){
        Integer commentCount = agentMapper.findCommentCount(agentId);
        return commentCount;
    }
    //查询经济人
    @RequestMapping("findAgent")
    @ResponseBody
    public HashMap<String,Object> findAgent(@RequestParam Integer page, @RequestParam Integer rows,@RequestBody AgentBean agentBean){
        System.out.println(agentBean);
        HashMap<String, Object> map = new HashMap<>();
        Integer total = agentMapper.findCountAgent(agentBean);
        Integer start = (page-1)*rows;
        List<AgentBean> list = agentMapper.findAgent(start,rows,agentBean);
        for (int i = 0 ; i < list.size() ;i++){
            Integer commentCount = agentMapper.findCommentCount(list.get(i).getAgentId());
            list.get(i).setCommentCount(commentCount);
        }
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
    //查询小区
    @RequestMapping("findHouse")
    @ResponseBody
    public List<House> findHouse(){
        return agentMapper.findHouse();
    }
    //查询标签
    @RequestMapping("findLabel")
    @ResponseBody
    public List<LabelBean> findLabel(){
        return agentMapper.findLabel();
    }
}
