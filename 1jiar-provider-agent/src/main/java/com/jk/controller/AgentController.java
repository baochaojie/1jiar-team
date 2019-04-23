package com.jk.controller;

import com.jk.mapper.AgentMapper;
import com.jk.model.*;
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
        Integer agentId =agentBean.getAgentId();
        if(agentId!=null){
            //修改
            agentMapper.updateAgent(agentBean);
        }else{
            agentMapper.saveAgent(agentBean);
        }
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
    @RequestMapping("findExhibition/{agentId}")
    @ResponseBody
    public List<Exhibition> findExhibition(@PathVariable("agentId") Integer agentId){
        return agentMapper.findExhibition(agentId);
    }
    @RequestMapping("findGuide")
    @ResponseBody
    public List<DictionaryTable> findGuide() {
        Integer pid = 100;
        List<DictionaryTable> list = queryTree(pid);
        return list;
    }
    private List<DictionaryTable> queryTree(@RequestParam Integer pid) {
        List<DictionaryTable> list = agentMapper.queryTree(pid);
        for (DictionaryTable dictionaryTable : list) {
            Integer id = dictionaryTable.getId();
            List<DictionaryTable> nodes =  queryTree(id);
            if(nodes.size()<= 0){
                //无子节点
                dictionaryTable.setSelectable(true);
            }else{
                //有节点
                dictionaryTable.setSelectable(false);
                dictionaryTable.setNodes(nodes);
            }
        }
        return list;
    }
    //新增问题
    @RequestMapping("addProblemInfoById")
    @ResponseBody
    public void addProblemInfoById(@RequestBody Problem problem){
        System.out.println(problem);
        agentMapper.addProblemInfoById(problem);
    }
    //查询问题
    @RequestMapping("findProblem")
    @ResponseBody
    List<Problem> findProblem(){
        return agentMapper.findProblem();
    }

    @RequestMapping("findEcharts")
    @ResponseBody
    public List<House> findEcharts(Integer agentId){
        return agentMapper.findEcharts(agentId);
    }
}
