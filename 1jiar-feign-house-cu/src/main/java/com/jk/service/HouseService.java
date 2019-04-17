package com.jk.service;

import com.jk.model.Area;
import com.jk.model.House;
import com.jk.model.Subway;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@FeignClient("springcloud-house-reg") //指定生产者的实例名称
public interface HouseService {
    @RequestMapping("queryhouse")
    @ResponseBody
    HashMap<String, Object> findHousePage(@RequestParam Integer page, @RequestParam Integer rows, @RequestBody House house);

    @RequestMapping("queryquyu")
    @ResponseBody
    List<Area> queryquyu(@RequestParam Integer pid);

    @RequestMapping("queryditie")
    @ResponseBody
    List<Subway> queryditie(@RequestParam Integer pid);
}
