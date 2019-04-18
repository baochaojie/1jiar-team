package com.jk.service;

import com.jk.model.HouseAge;
import com.jk.model.Owner;
import com.jk.model.UserBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(value = "1jiar-provider-house-ad")
public interface HouseService {

    @GetMapping("queryHouseAge")
    List<HouseAge> queryHouseAge();

    @RequestMapping("addOwner")
    void addOwner(@RequestBody Owner owner);
    @RequestMapping("addOwner2")
    void addOwner2(@RequestBody UserBean userBean);
}
