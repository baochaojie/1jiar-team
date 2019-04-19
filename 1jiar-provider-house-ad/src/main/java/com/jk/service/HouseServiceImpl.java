package com.jk.service;

import com.jk.mapper.HouseMapper;
import com.jk.model.Area;
import com.jk.model.HouseAge;
import com.jk.model.Owner;
import com.jk.model.UserBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class HouseServiceImpl {

    @Autowired
    private HouseMapper houseMapper;

    /**
     * 此方法用来查询数据库中房龄信息
     * 现用来测试是否与MySQL数据库连接成功
     * @return
     */
    @GetMapping("queryHouseAge")
    @ResponseBody
    public List<HouseAge> queryHouseAge(){
        return houseMapper.queryHouseAge();
    }

    /**
     * 此方法用来向数据库添加待审核数据
     * @param owner
     */
    @RequestMapping("addOwner")
    @ResponseBody
    public void addOwner(@RequestBody Owner owner){
        owner.setOwnerUserId(ownerUserId);
        houseMapper.addOwner(owner);
    };
    /**
     * 先添加房主userBean的信息然后返回一个ownerUserId,
     * 把这个ownerUserId再赋到owner表
     */
    Integer ownerUserId;
    @RequestMapping("addOwner2")
    @ResponseBody
    public void addOwner2(@RequestBody UserBean userBean){
        houseMapper.addOwner2(userBean);
        Integer id = userBean.getId();
        ownerUserId=id;
    };

    /**
     * 此方法用于分页查询已录入的待审核信息
     * @param map
     * @return
     */
    int a = 1;
    @PostMapping("queryOwner")
    @ResponseBody
    public HashMap<String, Object> queryOwner(@RequestBody Map<String, Object> map){
        HashMap<String,Object> hashMap=new HashMap<>();
        Integer page= (Integer) map.get("page");
        Integer rows= (Integer) map.get("rows");
        String name= (String) map.get("name");
        String ownerState= (String) map.get("ownerState");
System.out.println(a);
a++;
        //条查数据放到owner对象里
        Owner owner=new Owner();
        owner.setName(name);
        owner.setOwnerXiaoqu(name);
        owner.setOwnerState(ownerState);
        //查询出总条数
        int total=houseMapper.findHouseCount(owner);
        //分页
        int start = (page-1)*rows;//开始条数

        //查询出房屋信息表中和房屋相关的信息
        List<Owner> list=houseMapper.queryOwnerHouse(start,rows,owner);
        //查询出房屋信息表中和house_man表有关的数据
        hashMap.put("total", total);
        hashMap.put("rows", list);
        return hashMap;
    }
    @RequestMapping("initcity")
    @ResponseBody
    public List<Area> initcity(@RequestParam Integer pid){
        List<Area> areas=houseMapper.initcity(pid);
        return areas;
    }
}
