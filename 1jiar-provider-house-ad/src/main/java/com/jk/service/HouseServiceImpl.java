package com.jk.service;

import com.jk.mapper.HouseMapper;
import com.jk.model.HouseAge;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
}
