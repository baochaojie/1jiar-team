package com.jk.service;

import com.jk.model.AgentBean;
import com.jk.model.AreaBean;
import com.jk.model.House;
import com.jk.model.LabelBean;
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
    @RequestMapping("findHouse")
    @ResponseBody
    public List<House> findHouse();
    @RequestMapping("findLabel")
    @ResponseBody
    List<LabelBean> findLabel();
}
