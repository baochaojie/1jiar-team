package com.jk.service.impl;

import com.jk.mapper.HouseMapper;
import com.jk.model.House;
import com.jk.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class HouseServiceImpl implements HouseService {
    @Autowired
    private HouseMapper houseMapper;

    @Override
    public List<House> queryhouse() {
        return houseMapper.queryhouse();
    }
}
