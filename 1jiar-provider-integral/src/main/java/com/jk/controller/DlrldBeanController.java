package com.jk.controller;

import com.jk.model.DlrldBean;
import com.jk.model.DlrldIntegrelBean;
import com.jk.model.DlrldTypeBean;
import com.jk.service.DlrldBeanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Controller
public class DlrldBeanController {

    @Autowired
    private DlrldBeanService dlrldBeanService;


    //查询历史中奖纪录
    @RequestMapping("QueryMembershipPoint")
    @ResponseBody
    public List<DlrldBean> QueryMembershipPoint(){
        return  dlrldBeanService.QueryMembershipPoint();
    }

    //查询历史中奖纪录
    @RequestMapping("queryDlrld")
    @ResponseBody
    public List<DlrldBean> queryDlrld(@RequestParam Integer houseId){
        System.out.println(houseId);
        return  dlrldBeanService.queryDlrld(houseId);
    }

    //抽奖回显
    @RequestMapping("querydlrldId")
    @ResponseBody
    public DlrldBean querydlrldId(@RequestParam Integer houseId){
        return  dlrldBeanService.querydlrldId(houseId);
    }


    //查询奖品
    @RequestMapping("queryprize")
    @ResponseBody
    public List<DlrldTypeBean> queryprize(){
        return  dlrldBeanService.queryprize();
    }

    //查询奖品级别
    @RequestMapping("typelist")
    @ResponseBody
    public List<DlrldIntegrelBean> typelist(){
        return  dlrldBeanService.typelist();
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
