package com.jk.controller;

import com.jk.model.DlrldBean;
import com.jk.model.DlrldIntegrelBean;
import com.jk.model.DlrldTypeBean;
import com.jk.service.DlrldBeanService;
import com.jk.utils.OSSClientUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Controller
public class DlrldBeanController {

    @Autowired
    private DlrldBeanService dlrldBeanService;



    //查询用户积分余额
    @RequestMapping("show")
    public String show(){
        return "booklist";
    }

    //查询用户积分余额
    @RequestMapping("QueryMembershipPoint")
    @ResponseBody
    public List<DlrldBean> QueryMembershipPoint(Integer houseId){
        houseId=1;
        List<DlrldBean>  list =   dlrldBeanService.QueryMembershipPoint(houseId);
        System.out.println(list);
        return  list;
    }

    //查询历史中奖纪录
    @RequestMapping("queryDlrld")
    @ResponseBody
    public List<DlrldBean> queryDlrld(Integer houseId){
        return  dlrldBeanService.queryDlrld(houseId);
    }

    @RequestMapping("choujiang")
    public String choujiang(){
        return "choujiang";
    }

    //抽奖回显
    @RequestMapping("querydlrldId")
    @ResponseBody
    public DlrldBean querydlrldId(Integer houseId){
        return  dlrldBeanService.querydlrldId(houseId);
    }

    //抽奖
    @RequestMapping("saveDlrldBean")
    @ResponseBody
    public void saveDlrldBean(DlrldBean DlrldBean){
        dlrldBeanService.saveDlrldBean(DlrldBean);
    }

    //查询奖品级别
    @RequestMapping("typelist")
    @ResponseBody
    public List<DlrldIntegrelBean> typelist(){
        return  dlrldBeanService.typelist();
    }

    //查询奖品
    @RequestMapping("prize")
    public String prize(){
        return "addbook";
    }

    //查询奖品 redis
    @RequestMapping("queryprize")
    @ResponseBody
    public List<DlrldTypeBean> queryprize(Integer dltypeid){
        return  dlrldBeanService.queryprize(dltypeid);
    }

    String awardImg ="";
    //上传图片
    @RequestMapping("text")
    @ResponseBody
    public String uploadImg(MultipartFile file)throws IOException {
        if (file == null || file.getSize() <= 0) {
            throw new IOException("file不能为空");
        }
        OSSClientUtil ossClient=new OSSClientUtil();
        String name = ossClient.uploadImg2Oss(file);
        String imgUrl = ossClient.getImgUrl(name);
        String[] split = imgUrl.split("\\?");
        awardImg=split[0];
        return split[0];
    }
    @RequestMapping("src")
    public String src(){
        return "addbook";
    }


    //新增奖品
    @RequestMapping("saveprize")
    @ResponseBody
    public void saveprize(DlrldTypeBean dlrldTypeBean){
        dlrldTypeBean.setAwardImg(awardImg);
        dlrldBeanService.saveprize(dlrldTypeBean);
    }

    //删除
    @RequestMapping("deleteTyped")
    @ResponseBody
    public void deleteTyped(Integer ids){
        dlrldBeanService.deleteTyped(ids);
    }
}
