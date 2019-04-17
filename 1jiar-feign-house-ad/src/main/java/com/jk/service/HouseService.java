package com.jk.service;

import com.jk.model.HouseAge;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(value = "1jiar-provider-house-ad")
public interface HouseService {

    @GetMapping("queryHouseAge")
    List<HouseAge> queryHouseAge();
}
