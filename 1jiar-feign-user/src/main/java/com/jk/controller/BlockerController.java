package com.jk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("blocker")
public class BlockerController {

    @Autowired
    private RedisTemplate redisTemplate;

    @RequestMapping("zenghe")
    public String userguanliyuan(String gmmishi){
        if (gmmishi==null||gmmishi==""){
            return "initlog";
        }
        Boolean aBoolean = redisTemplate.hasKey(gmmishi);
        if (aBoolean) {
            return "zenghe";
        }
        return "initlog";
    }
    @RequestMapping("zenghe1")
    @ResponseBody
    public String userguanliyuan1(String gmmishi){
        redisTemplate.opsForValue().set(gmmishi,"GM");
        return "成功";
    }
}
