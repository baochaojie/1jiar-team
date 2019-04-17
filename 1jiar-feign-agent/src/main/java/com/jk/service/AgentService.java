package com.jk.service;

import com.jk.model.AgentBean;
import com.jk.model.AreaBean;
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
    List<AreaBean> findRegion(@PathVariable("id") Integer id);
    @RequestMapping("findAgentInfoById/{agentId}")
    @ResponseBody
    public AgentBean findAgentInfoById(@PathVariable("agentId") Integer agentId);
    @RequestMapping("deleteAgent/{ids}")
    @ResponseBody
    public Boolean deleteAgent(@PathVariable("ids") Integer[]ids);
}
