package com.jk.mapper;

import com.jk.model.House;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface HouseMapper {
    List<House> queryhouse();
}
