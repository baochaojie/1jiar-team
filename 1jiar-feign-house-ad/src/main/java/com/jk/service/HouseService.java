package com.jk.service;

import com.jk.model.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@FeignClient(value = "1jiar-provider-house-ad")
public interface HouseService {

    @GetMapping("queryHouseAge")
    List<HouseAge> queryHouseAge();

    @RequestMapping("addOwner")
    void addOwner(@RequestBody Owner owner);
    @RequestMapping("addOwner2")
    void addOwner2(@RequestBody UserBean userBean);

    @PostMapping("queryOwner")
    @ResponseBody
    HashMap queryOwner(@RequestBody Map<String, Object> map);

    @PostMapping("initcity")
    @ResponseBody
    List<Area> initcity(@RequestParam Integer pid);

    @RequestMapping("addhousemoreinfo")
    @ResponseBody
    void addhousemoreinfo(@RequestBody House house);
}
