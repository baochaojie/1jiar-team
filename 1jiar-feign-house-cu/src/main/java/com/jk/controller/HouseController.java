package com.jk.controller;

import com.jk.model.Area;
import com.jk.model.House;
import com.jk.model.Subway;
import com.jk.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("house")
public class HouseController {
    @Autowired
    private HouseService houseService;
    //跳转出租房屋页面
    @RequestMapping("chazhubiao")
    public String chazhubiao() {
        return "queryHouse";
    }
    //跳转出租付款页面
    @RequestMapping("chuzuFuKuan")
    public String chuzuFuKuan() {
        return "chuzuFuKuan";
    }//跳转出租付款页面

    @RequestMapping("chushouFuKuan")
    public String chushouFuKuan() {
        return "chushouFuKuan";
    }
    @RequestMapping("qiantai")
    public String qiantai() {
        return "qiantai";
    }

    //跳转出售房屋页面
    @RequestMapping("Chushouhouse")
    public String ChuShouHouse() {
        return "ChShouHouse";
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
    //删除
    @ResponseBody
    @RequestMapping("deleteItem")
    public Integer deleteItem(String ids,Integer agentId){
        houseService.deleteItem(ids,agentId);
        return 1;
    }
    //删除
    @ResponseBody
    @RequestMapping("LookHouse")
    public Integer LookHouse(Integer agentId){
        houseService.LookHouse(agentId);
        return 1;
    }
    //回显
    @RequestMapping("findHouseById")
    @ResponseBody
    public House findHouseById(Integer houseId){
        return houseService.findHouseById(houseId);
    }

    //跳转出租房屋页面
    @RequestMapping("chaIdHouse")
    public String chaIdHouse() {
        return "chaIdHouse";
    }
    //根据id查询
    @RequestMapping("queryIdhouse")
    @ResponseBody
    public List<House> queryIdhouse(Integer houseId){
        return houseService.queryIdhouse(houseId);

    }
    //收藏
    @RequestMapping("shouCang")
    @ResponseBody
    public void shouCang(House house,Integer pid){
        house.setHouseId(pid);
        houseService.shouCang(house);
    }
    //跳转前台详情页面
    @RequestMapping("chaxiangqing")
    public String chaxiangqing(Model model, Integer id) {
        model.addAttribute("ids",id);
        return "XiangQing";
    }
    //跳转详情页面
    @RequestMapping("queryXiangQing")
    @ResponseBody
    public House queryXiangQing( Integer houseId){
        return houseService.queryXiangQing(houseId);

    }
    //跳转详情页面
    /*@RequestMapping("queryXiangQing")
    @ResponseBody
    public void zengjifen( Integer price){
        return houseService.zengjifen(price);

    }
*/
}
