package com.jk.controller;

import com.jk.model.Area;
import com.jk.model.HouseAge;
import com.jk.model.Owner;
import com.jk.model.UserBean;
import com.jk.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class HouseController {

    @Autowired
    private HouseService houseService;
    /**
     * 此方法用来查询房龄信息
     * 这里用作测试是否连到MySQL数据库
     * @return
     */
    @GetMapping("queryHouseAge")
    @ResponseBody
    public List<HouseAge> queryHouseAge(){
        return houseService.queryHouseAge();
    }
    /**
     * 此方法用来添加待审核信息
     * @param owner
     * @return
     */
    @RequestMapping("addOwner")
    @ResponseBody
    public Boolean addOwner(Owner owner,UserBean userBean){
        houseService.addOwner2(userBean);
        houseService.addOwner(owner);
        return true;
    }
    /**
     * 跳转到添加待审核信息的前台页面
     * @return
     */
    @RequestMapping("toaddhouseinfo")
    public String toaddhouseinfo(){
        return "addhouseinfo";
    }
    /**
     * 跳转到展示已添加待审核信息的前台页面
     */
    @RequestMapping("toshowhouseinfo")
    public String toshowhouseinfo(){
        return "showhouseinfo";
    }

    /**
     * 分页查询已录入的待审核信息
     * @param map
     * @return
     */
    @PostMapping("queryOwner")
    @ResponseBody
    public HashMap<String ,Object> queryOwner(@RequestBody Map<String, Object> map){

        HashMap ownerinfo=houseService.queryOwner(map);
        return ownerinfo;
    }

    /**
     * 查询地区表字段到前台下拉列表
     * @param pid
     * @return
     */
    @RequestMapping("initcity")
    @ResponseBody
    public List<Area> initcity(Integer pid){
        List<Area> areas=houseService.initcity(pid);
        return areas;
    }
}
