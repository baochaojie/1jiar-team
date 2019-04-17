package com.jk.controller;

import com.jk.model.HouseAge;
import com.jk.model.Owner;
import com.jk.model.UserBean;
import com.jk.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

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
}
