package com.jk.controller;

import com.jk.model.Area;
import com.jk.model.House;
import com.jk.model.Subway;
import com.jk.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@Controller
public class HouseController {
    @Autowired
    private HouseService houseService;
    @RequestMapping("queryhouse")
    @ResponseBody
    public HashMap<String, Object> findHousePage(@RequestParam Integer page, @RequestParam Integer rows, @RequestBody House house){
        return houseService.findHousePage(page,rows,house);
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
    public Integer deleteItem(@RequestParam String ids){
        houseService.deleteItem(ids);
        return 1;
    }
}
