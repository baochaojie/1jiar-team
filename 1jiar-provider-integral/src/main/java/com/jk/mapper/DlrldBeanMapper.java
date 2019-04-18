package com.jk.mapper;

import com.jk.model.DlrldBean;
import com.jk.model.DlrldIntegrelBean;
import com.jk.model.DlrldTypeBean;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface DlrldBeanMapper {

    @Select("select hd.*,di.dltypeName as dltyname,di.dltymoney as dley,\n" +
            "                  hd.takeTime as tame,hd.dlrldtyId as dllid,\n" +
            "                  dt.dlrldName as dllname,dt.awardImg as awardImg\n" +
            "                  from house_dlrld hd left join dltle_integral di on hd.prizeTypeid=di.dltypeid\n" +
            "                                         left join dlrld_type dt on hd.dlrldtyId=dt.dlrldtyId " +
            "                                  where hd.houseId = #{houseId}")
    List<DlrldBean> queryDlrld(Integer houseId);

    @Select("select hd.*,di.dltypeName as dltyname,di.dltymoney as dley,\n" +
            "                  hd.takeTime as tame,hd.dlrldtyId as dllid,\n" +
            "                  dt.dlrldName as dllname,dt.awardImg as awardImg\n" +
            "                  from house_dlrld hd left join dltle_integral di on hd.prizeTypeid=di.dltypeid\n" +
            "                                         left join dlrld_type dt on hd.dlrldtyId=dt.dlrldtyId")
    List<DlrldBean> QueryMembershipPoint();

    @Select("select dt.*,di.dltypeName as integName from dlrld_type dt left join dltle_integral di on dt.prizeId=di.dltypeid")
    List<DlrldTypeBean> queryprize();

    @Select("select * from dltle_integral")
    List<DlrldIntegrelBean> typelist();

    void saveprize(DlrldTypeBean dlrldTypeBean);

    @Delete("delete from dlrld_type where dlrldtyId = #{ids}")
    void deleteTyped(Integer ids);

    @Select("select * from house_dlrld  where houseId = #{houseId} ")
    DlrldBean querydlrldId(Integer houseId);
}
