package com.jk.service;

import com.jk.mapper.HouseMapper;
import com.jk.model.HouseAge;
import com.jk.model.Owner;
import com.jk.model.UserBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
}
