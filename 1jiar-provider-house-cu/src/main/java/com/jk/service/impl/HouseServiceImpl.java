package com.jk.service.impl;

import com.jk.mapper.HouseMapper;
import com.jk.model.Area;
import com.jk.model.House;
import com.jk.model.Subway;
import com.jk.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
@Component
public class HouseServiceImpl implements HouseService {
    @Autowired
    private HouseMapper houseMapper;

    @Override
    public HashMap<String, Object> findHousePage(Integer page, Integer rows, House house) {

        HashMap<String, Object> hashMap = new HashMap<>();
        //查询总条数
        int total = houseMapper.findHouseCount(house);

        //分页查询
        int start = (page-1)*rows;//开始条数
        List<House> list = houseMapper.findHousePage(start,rows,house);
        //查询特色
        for(int i=0;i<list.size();i++){
            String houseTeSeIdname ="";
            String houseTeSeId = list.get(i).getHouseTeSeId();
            String[] split = houseTeSeId.split(",");
            for (int j=0;j<split.length;j++){
                Integer TeSeId = Integer.parseInt(split[j]);
                String tesename =houseMapper.featurenamebyid(TeSeId);
                houseTeSeIdname += houseTeSeIdname==""? tesename :","+ tesename;
             }
            list.get(i).setHouseTeSeId(houseTeSeIdname);
        }
        hashMap.put("total", total);
        hashMap.put("rows", list);
        return hashMap;
    }

    @Override
    public List<Area> findArea(Integer pid) {
       return houseMapper.findArea(pid);
    }

    @Override
    public List<Subway> queryditie(Integer pid) {
        return houseMapper.queryditie(pid);
    }

    @Override
    public Integer deleteItem(String ids) {
        houseMapper.deleteItem(ids);
        return 1;

    }

}
