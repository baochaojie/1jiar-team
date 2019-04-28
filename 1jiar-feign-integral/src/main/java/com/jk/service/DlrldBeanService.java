package com.jk.service;

import com.jk.model.DlrldBean;
import com.jk.model.DlrldIntegrelBean;
import com.jk.model.DlrldTypeBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@FeignClient("springcloud-user-hjk")
public interface DlrldBeanService {

    //查询用户积分余额
    @RequestMapping("QueryMembershipPoint")
    List<DlrldBean> QueryMembershipPoint(@RequestParam Integer houseId);

    //查询历史中奖纪录
    @PostMapping("queryDlrld")
    List<DlrldBean> queryDlrld(@RequestParam Integer houseId);

    //后台查询历史中奖纪录
    @PostMapping("queryDlrldht")
    HashMap<String, Object> queryDlrldht(@RequestParam Integer page, @RequestParam Integer rows, @RequestBody DlrldBean dlrldBean);

    //查询奖品 redis
    @PostMapping("queryprize")
    List<DlrldTypeBean> queryprize(@RequestParam Integer dltypeid);

    //查询奖品级别
    @RequestMapping("typelist")
    List<DlrldIntegrelBean> typelist();

    @RequestMapping("saveprize")
    void saveprize(@RequestBody DlrldTypeBean dlrldTypeBean);

    @GetMapping("deleteTyped")
    void deleteTyped(@RequestParam Integer ids);

    @PostMapping("querydlrldId")
    DlrldBean querydlrldId(@RequestParam Integer houseId);

    @RequestMapping("saveDlrldBean")
    String saveDlrldBean(@RequestBody DlrldBean dlrldBean, @RequestParam Integer intee, @RequestParam Integer integral, @RequestParam Integer houseId);

    @PostMapping("queryprize2")
    List<DlrldTypeBean> queryprize2();

    @PostMapping("lingquTyped")
    void lingquTyped(@RequestParam Integer dlrIdId, @RequestParam Integer houseId);

    @PostMapping("fangqiTyped")
    void fangqiTyped(@RequestParam Integer dlrIdId, @RequestParam Integer houseId);

    @PostMapping("UpMembershipPoint")
    void UpMembershipPoint(@RequestParam Integer houseId, @RequestParam Integer integralAdd);
}
