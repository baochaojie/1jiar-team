package com.jk.service;

import com.jk.model.AgentBean;
import com.jk.model.AreaBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@FeignClient("1jiar-provider-agent")
public interface AgentService {
    @RequestMapping("findAgent")
    @ResponseBody
    HashMap<String, Object> findAgent(@RequestParam Integer page,@RequestParam Integer rows,@RequestBody AgentBean agentBean);
    @RequestMapping("saveAgent")
    @ResponseBody
    void saveAgent(@RequestBody AgentBean agentBean);
    @RequestMapping("findRegion/{id}")
    @ResponseBody
    List<AreaBean> findRegion(@PathVariable("id") Integer id);
}
