package com.jk.controller;

import com.jk.mapper.AgentMapper;
import com.jk.model.*;
import com.jk.utils.OSSClientUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
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
    
    @Autowired
    private RedisTemplate redisTemplate;

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
        if(redisTemplate.hasKey("queryAgent"+page)){
            System.out.println("ertyui");
           map = (HashMap<String, Object>) redisTemplate.opsForValue().get("queryAgent"+page);
        }else{
            System.out.println("aaa");
            Integer total = agentMapper.findCountAgent(agentBean);
            Integer start = (page-1)*rows;
            List<AgentBean> list = agentMapper.findAgent(start,rows,agentBean);
            for (int i = 0 ; i < list.size() ;i++){
                Integer commentCount = agentMapper.findCommentCount(list.get(i).getAgentId());
                list.get(i).setCommentCount(commentCount);
            }
            map.put("total",total);
            map.put("rows",list);
            redisTemplate.opsForValue().set("queryAgent"+page,map);
        }
        /*Integer total = agentMapper.findCountAgent(agentBean);
        Integer start = (page-1)*rows;
        List<AgentBean> list = agentMapper.findAgent(start,rows,agentBean);
        for (int i = 0 ; i < list.size() ;i++){
            Integer commentCount = agentMapper.findCommentCount(list.get(i).getAgentId());
            list.get(i).setCommentCount(commentCount);
        }
        map.put("total",total);
        map.put("rows",list);*/
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
        List<Object> range = redisTemplate.opsForList().range("houseList", 0, -1);
        if (range != null && range.size()>0){
            List<House> object = (List<House>) range.get(0);
            return object;
        }
        List<House> list=agentMapper.findHouse();
        if(list == null){
            redisTemplate.opsForList().leftPush("houseList",list);
        }else {
            redisTemplate.opsForList().leftPush("houseList",list);
        }
        System.out.println(list);
        return list;
        //return agentMapper.findHouse();
    }
    //查询标签
    @RequestMapping("findLabel")
    @ResponseBody
    public List<LabelBean> findLabel(){
        List<Object> range = redisTemplate.opsForList().range("labelList", 0, -1);
        if (range != null && range.size()>0){
            List<LabelBean> object = (List<LabelBean>) range.get(0);
            return object;
        }
        List<LabelBean> list=agentMapper.findLabel();
        if(list == null){
            redisTemplate.opsForList().leftPush("labelList",list);
        }else {
            redisTemplate.opsForList().leftPush("labelList",list);
        }
        System.out.println(list);
        return list;
       // return agentMapper.findLabel();
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
        List<Object> range = redisTemplate.opsForList().range("problemList", 0, -1);
        if (range != null && range.size()>0){
            List<Problem> object = (List<Problem>) range.get(0);
            return object;
        }
        List<Problem> list=agentMapper.findProblem();
        if(list == null){
            redisTemplate.opsForList().leftPush("problemList",list);
        }else {
            redisTemplate.opsForList().leftPush("problemList",list);
        }
        System.out.println(list);
        return list;
        //return agentMapper.findProblem();
    }

    @RequestMapping("findEcharts")
    @ResponseBody
    public List<House> findEcharts(){
        System.out.println(44444);
        List<House> list = agentMapper.findEcharts();

        return list;
    }

}
