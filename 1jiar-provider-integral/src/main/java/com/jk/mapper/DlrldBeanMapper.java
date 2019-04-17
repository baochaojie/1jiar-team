package com.jk.mapper;

import com.jk.model.DlrldBean;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface DlrldBeanMapper {

    @Select("SELECT hd.dlrIdId ,hd.integralAdd as 积分累计,\n" +
            "       hd.houseId as 用户id , hd.prizeTypeid  as 奖品类型id,\n" +
            "      di.dltypeName 奖品类型,di.dltymoney as 所用的积分,\n" +
            "      hd.takeTime as 抽奖时间,hd.dlrldtyId as 抽奖ID,\n" +
            "      dt.dlrldName as 奖品名称,dt.awardImg as 奖品图片\n" +
            "      from house_dlrld hd LEFT JOIN dltle_integral di on hd.prizeTypeid=di.dltypeid\n" +
            "                             LEFT JOIN dlrld_type dt on hd.dlrldtyId=dt.dlrldtyId\n" +
            "    where hd.houseId=#{houseId}")
    List<DlrldBean> queryDlrld(Integer houseId);
}
