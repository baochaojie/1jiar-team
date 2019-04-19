package com.jk.mapper;

import com.jk.model.Area;
import com.jk.model.HouseAge;
import com.jk.model.Owner;
import com.jk.model.UserBean;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface HouseMapper {


    List<HouseAge> queryHouseAge();

    void addOwner(Owner owner);

    void addOwner2(UserBean userBean);

    List<Owner> queryOwnerHouse(@Param("start") int start,@Param("rows")Integer rows,@Param("owner")Owner owner);

    int findHouseCount(@Param("owner")Owner owner);

    List<Area> initcity(Integer pid);
}
