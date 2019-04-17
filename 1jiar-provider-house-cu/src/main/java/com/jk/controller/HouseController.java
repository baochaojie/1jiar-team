package com.jk.controller;

import com.jk.model.House;
import com.jk.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class HouseController {
    @Autowired
    private HouseService houseService;
    @RequestMapping("queryhouse")
    @ResponseBody
    public List<House> queryBook( House house){
        System.out.println("feign调用生产者成功。。。。。。。。。");
        List<House> list = null;

          list= houseService.queryhouse();
        return list;

    }
}
