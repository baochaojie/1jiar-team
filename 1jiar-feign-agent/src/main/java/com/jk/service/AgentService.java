package com.jk.service;

import com.jk.model.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@FeignClient("1jiar-provider-agent")
public interface AgentService {
    //查询经济人
    @RequestMapping("findAgent")
    @ResponseBody
    HashMap<String, Object> findAgent(@RequestParam Integer page,@RequestParam Integer rows,@RequestBody AgentBean agentBean);
    //新增经济人
    @RequestMapping("saveAgent")
    @ResponseBody
    void saveAgent(@RequestBody AgentBean agentBean);
    //查询地区
    @RequestMapping("findRegion/{id}")
    @ResponseBody
    //查询地区
    List<AreaBean> findRegion(@PathVariable("id") Integer id);
    @RequestMapping("findAgentInfoById/{agentId}")
    @ResponseBody
    //回显经济人
    public AgentBean findAgentInfoById(@PathVariable("agentId") Integer agentId);
    @RequestMapping("deleteAgent/{ids}")
    @ResponseBody
    public Boolean deleteAgent(@PathVariable("ids") Integer[]ids);
    //查询评论
    @PostMapping
    @ResponseBody
    public Integer findCommentCount(@RequestParam Integer agentId);
    //查询小区
    @RequestMapping("findHouse")
    @ResponseBody
    public List<House> findHouse();
    //查询标签
    @RequestMapping("findLabel")
    @ResponseBody
    List<LabelBean> findLabel();
    //查询成交小区
    @RequestMapping("findExhibition/{agentId}")
    @ResponseBody
    public List<AgentBean> findExhibition(@PathVariable("agentId") Integer agentId);
    @RequestMapping("findGuide")
    @ResponseBody
    public List<DictionaryTable> findGuide();

    @RequestMapping("addProblemInfoById")
    @ResponseBody
    public void addProblemInfoById(@RequestBody Problem problem);
    //查询问题
    @RequestMapping("findProblem")
    @ResponseBody
    List<Problem> findProblem();

    @RequestMapping("findEcharts")
    @ResponseBody
    public List<House> findEcharts();
    @RequestMapping("findAgents")
    @ResponseBody
    AgentBean findAgents(@RequestParam(value = "id") String id);
//查询区域
    @RequestMapping("queryArea")
    @ResponseBody
    List<Area> queryArea(@RequestParam  Integer pid);
   //地区条查
    @RequestMapping("findAgents2")
    @ResponseBody
    List<AgentBean> findAgents2(@RequestParam Integer id);
}
