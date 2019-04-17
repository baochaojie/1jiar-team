package com.jk.controller;

import com.jk.model.Area;
import com.jk.model.House;
import com.jk.model.Subway;
import com.jk.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("house")
public class HouseController {
    @Autowired
    private HouseService houseService;
    //跳转查询页面
    @RequestMapping("chazhubiao")
    public String chazhubiao() {
        return "queryHouse";
    }
    //房屋主表查询
    @RequestMapping("queryhouse")
    @ResponseBody
    public HashMap<String, Object> findUserPage(Integer page, Integer rows, House house ){

        return houseService.findHousePage(page,rows,house);
    }
    //查询地区
    @RequestMapping("queryquyu")
    @ResponseBody
    public List<Area> queryquyu(Integer pid){
        return houseService.queryquyu(pid);
    }
    //查询地铁
    @RequestMapping("queryditie")
    @ResponseBody
    public List<Subway> queryditie(Integer pid){
        return houseService.queryditie(pid);

    }
}
