package com.jk.controller;

import com.jk.model.DlrldBean;
import com.jk.model.DlrldIntegrelBean;
import com.jk.model.DlrldTypeBean;
import com.jk.service.DlrldBeanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Controller
public class DlrldBeanController {

    @Autowired
    private DlrldBeanService dlrldBeanService;



    //查询用户积分余额 redis
    @RequestMapping("QueryMembershipPoint")
    @ResponseBody
    public List<DlrldBean> QueryMembershipPoint(@RequestParam Integer houseId){
        return  dlrldBeanService.QueryMembershipPoint(houseId);
    }

    //查询历史中奖纪录 redis
    @RequestMapping("queryDlrld")
    @ResponseBody
    public List<DlrldBean> queryDlrld(@RequestParam Integer houseId){
        return  dlrldBeanService.queryDlrld(houseId);
    }

    //抽奖回显
    @RequestMapping("querydlrldId")
    @ResponseBody
    public DlrldBean querydlrldId(@RequestParam Integer houseId){
        return  dlrldBeanService.querydlrldId(houseId);
    }

    //抽奖
    @RequestMapping("saveDlrldBean")
    @ResponseBody
    public void saveDlrldBean(@RequestBody DlrldBean DlrldBean){
        dlrldBeanService.saveDlrldBean(DlrldBean);
    }


    //查询奖品 redis
    @RequestMapping("queryprize")
    @ResponseBody
    public List<DlrldTypeBean> queryprize(@RequestParam Integer dltypeid){
        return  dlrldBeanService.queryprize(dltypeid);
    }

    //查询奖品级别 redis
    @RequestMapping("typelist")
    @ResponseBody
    public List<DlrldIntegrelBean> typelist(){
        List<DlrldIntegrelBean> list = dlrldBeanService.typelist();
        return  list;
    }

    //新增奖品
    @RequestMapping("saveprize")
    @ResponseBody
    public void saveprize(@RequestBody DlrldTypeBean dlrldTypeBean){
        dlrldBeanService.saveprize(dlrldTypeBean);
    }

    //删除
    @RequestMapping("deleteTyped")
    @ResponseBody
    public void deleteTyped(@RequestParam Integer ids){
         dlrldBeanService.deleteTyped(ids);
    }




}
