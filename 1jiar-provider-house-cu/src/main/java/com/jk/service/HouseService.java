package com.jk.service;


import com.jk.model.Area;
import com.jk.model.House;
import com.jk.model.Subway;

import java.util.HashMap;
import java.util.List;

public interface HouseService {


    HashMap<String, Object> findHousePage(Integer page, Integer rows, House house);

    List<Area> findArea(Integer pid);

    List<Subway> queryditie(Integer pid);

    Integer deleteItem(String ids ,Integer agentId);

    void LookHouse(Integer agentId);

    House findHouseById(Integer houseId);

    List<House> queryIdhouse(Integer houseId);

    void shouCang(House house);

    House queryXiangQing(Integer houseId);
}
