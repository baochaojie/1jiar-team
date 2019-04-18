package com.jk.mapper;

import com.jk.model.Area;
import com.jk.model.House;
import com.jk.model.Subway;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface HouseMapper {

    int findHouseCount(@Param("house")House house);

    List<House> findHousePage(@Param("start")int start, @Param("rows")Integer rows,@Param("house") House house);

    List<Area> findArea(Integer pid);

    List<Subway> queryditie(Integer pid);

    Integer deleteItem(@Param("ids") String ids);

    @Select(" select houseTeSeName from  house_feature  where houseTeSeId =#{value}")
    String featurenamebyid(int teSeId);
}
