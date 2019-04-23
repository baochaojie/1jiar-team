package com.jk.controller;

import com.jk.CommonConf;
import com.jk.model.Area;
import com.jk.model.House;
import com.jk.model.Subway;
import com.jk.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Controller
public class HouseController {
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private HouseService houseService;
    @RequestMapping("queryhouse")
    @ResponseBody
    public HashMap<String, Object> findHousePage(@RequestParam Integer page, @RequestParam Integer rows, @RequestBody House house){
        HashMap<String, Object> housePage=null;
       // List<Object> range = redisTemplate.opsForList().range(CommonConf.SMS_QUERYHOUSE+"_"+page+"_"+rows, 0, -1);
        //if(range == null || range.size()<=0){
            housePage = houseService.findHousePage(page, rows, house);
          //  redisTemplate.opsForList().leftPush(CommonConf.SMS_QUERYHOUSE+"_"+page+"_"+rows, housePage);
           // redisTemplate.expire(CommonConf.SMS_QUERYHOUSE+"_"+page+"_"+rows,1, TimeUnit.MINUTES);

       // }else{
         //   housePage = (HashMap<String, Object>) range.get(0);
      //  }
        return  housePage;

    }
    //查询地区
    @RequestMapping("queryquyu")
    @ResponseBody
    public List<Area> queryquyu(@RequestParam Integer pid){
        return houseService.findArea(pid);
    }
    //查询地铁
    @RequestMapping("queryditie")
    @ResponseBody
    public List<Subway> queryditie(@RequestParam Integer pid){
        return houseService.queryditie(pid);
    }

    //删除
    @ResponseBody
    @RequestMapping("deleteItem")
    public Integer deleteItem(@RequestParam String ids ,@RequestParam Integer agentId){
        houseService.deleteItem(ids,agentId);
        return 1;
    }
    //删除
    @ResponseBody
    @RequestMapping("LookHouse")
    public Integer LookHouse(@RequestParam Integer agentId){
        houseService.LookHouse(agentId);
        return 1;
    }
    //回显
    @RequestMapping("findHouseById")
    @ResponseBody
    public House findHouseById(Integer houseId){
        return houseService.findHouseById(houseId);
    }

   //根据id查询
    @RequestMapping("queryIdhouse")
    @ResponseBody
    public List<House> queryIdhouse(@RequestParam Integer houseId){
        return houseService.queryIdhouse(houseId);

    }

}
