package com.jk.mapper;

import com.jk.model.HouseAge;
import com.jk.model.Owner;
import com.jk.model.UserBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface HouseMapper {


    List<HouseAge> queryHouseAge();

    void addOwner(Owner owner);

    void addOwner2(UserBean userBean);
}
