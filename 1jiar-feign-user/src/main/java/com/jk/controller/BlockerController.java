package com.jk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("blocker")
public class BlockerController {

    @Autowired
    private RedisTemplate redisTemplate;


    @RequestMapping("zenghe")
    public String zenghe(){
        List guanliyuanzenghe = redisTemplate.opsForList().range("guanliyuanzenghe", 0, -1);
        if (guanliyuanzenghe==null||guanliyuanzenghe.size()<=0) {
            return "initlog";
        }

        return "zenghe";
    }
}
