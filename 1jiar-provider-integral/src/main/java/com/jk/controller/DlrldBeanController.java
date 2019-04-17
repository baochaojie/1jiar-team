package com.jk.controller;

import com.jk.model.DlrldBean;
import com.jk.service.DlrldBeanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

@Controller
public class DlrldBeanController {

    @Autowired
    DlrldBeanService dlrldBeanService;


    //查询
    @RequestMapping("queryDlrld")
    @ResponseBody
    public List<DlrldBean> queryDlrld(){
         Integer houseId = 2;
        List<DlrldBean> list = dlrldBeanService.queryDlrld(houseId);
        return list;
    }
}
