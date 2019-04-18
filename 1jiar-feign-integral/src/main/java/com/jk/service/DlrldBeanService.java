package com.jk.service;

import com.jk.model.DlrldBean;
import com.jk.model.DlrldIntegrelBean;
import com.jk.model.DlrldTypeBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient("springcloud-user-hjk")
public interface DlrldBeanService {

    @RequestMapping("QueryMembershipPoint")
    List<DlrldBean> QueryMembershipPoint();

    @PostMapping("queryDlrld")
    List<DlrldBean> queryDlrld(@RequestParam Integer houseId);

    @PostMapping("queryprize")
    List<DlrldTypeBean> queryprize(@RequestParam Integer dltypeid);

    @RequestMapping("typelist")
    List<DlrldIntegrelBean> typelist();

    @RequestMapping("saveprize")
    void saveprize(@RequestBody DlrldTypeBean dlrldTypeBean);

    @GetMapping("deleteTyped")
    void deleteTyped(@RequestParam Integer ids);

    @PostMapping("querydlrldId")
    DlrldBean querydlrldId(@RequestParam Integer houseId);

    @RequestMapping("saveDlrldBean")
    void saveDlrldBean(@RequestBody DlrldBean dlrldBean);
}
