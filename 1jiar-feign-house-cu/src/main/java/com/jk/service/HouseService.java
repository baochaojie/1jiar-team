package com.jk.service;

import com.jk.model.House;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@FeignClient("springcloud-house-reg") //指定生产者的实例名称
public interface HouseService {
    @RequestMapping("queryhouse")
    List<House> queryhouse();
}
