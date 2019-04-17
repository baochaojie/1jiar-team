package com.jk.controller;

import com.jk.model.House;
import com.jk.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("house")
public class HouseController {
    @Autowired
    private HouseService houseService;
    @RequestMapping("queryhouse")
    @ResponseBody
    public List<House> queryhouse() {
        List<House> queryhouse = houseService.queryhouse();

        return queryhouse;
    }
}
