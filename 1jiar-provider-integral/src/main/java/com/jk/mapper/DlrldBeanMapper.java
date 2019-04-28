package com.jk.mapper;

import com.jk.model.DlrldBean;
import com.jk.model.DlrldIntegrelBean;
import com.jk.model.DlrldTypeBean;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface DlrldBeanMapper {

    @Select("select hd.*,di.dltypeName as dltyname,di.dltymoney as dley,\n" +
            "                                          hd.takeTime as tame,hd.dlrldtyId as dllid,\n" +
            "                                          dt.dlrldName as dllname,dt.awardImg as awardImg,\n" +
            "                                          hm.name as userName,hm.loginimg as loimg\n" +
            "                                          from house_dlrld hd left join dltle_integral di on hd.prizeTypeid=di.dltypeid\n" +
            "                                                                 left join dlrld_type dt on hd.dlrldtyId=dt.dlrldtyId\n" +
            "                                                                 LEFT JOIN house_man hm on hd.houseId=hm.id\n" +
            "                                                where hd.houseId = #{value} and status=2")
    List<DlrldBean> queryDlrld(Integer houseId);

    //查询用户积分余额
    @Select("select hd.*,di.dltypeName as dltyname,di.dltymoney as dley,\n" +
            "                              hd.takeTime as tame,hd.dlrldtyId as dllid,\n" +
            "                              dt.dlrldName as dllname,dt.awardImg as awardImg,\n" +
            "                              hm.name as userName,hm.loginimg as loimg\n" +
            "                              from house_dlrld hd left join dltle_integral di on hd.prizeTypeid=di.dltypeid\n" +
            "                                                     left join dlrld_type dt on hd.dlrldtyId=dt.dlrldtyId\n" +
            "                                                     LEFT JOIN house_man hm on hd.houseId=hm.id\n" +
            "                                 where status=1 and houseId=#{houseId}")
    List<DlrldBean> QueryMembershipPoint(Integer houseId);

    @Select("select dt.*,di.dltypeName as integName from dlrld_type dt left join dltle_integral di on dt.prizeId=di.dltypeid where dltypeid = #{dltypeid}")
    List<DlrldTypeBean> queryprize(@Param("dltypeid") Integer dltypeid);

    @Select("select * from dltle_integral")
    List<DlrldIntegrelBean> typelist();

    void saveprize(DlrldTypeBean dlrldTypeBean);

    @Delete("delete from dlrld_type where dlrldtyId = #{ids}")
    void deleteTyped(Integer ids);

    @Select("select * from house_dlrld  where houseId = #{houseId} and status=1 ")
    DlrldBean querydlrldId(Integer houseId);

    @Insert("insert into house_dlrld(integralAdd,houseId,prizeTypeid,dlrldtyId,stateId,takeTime,status) values(#{integral},#{houseId},#{dlrldBean.prizeTypeid},#{dlrldBean.dlrldtyId},1,sysdate(),2)")
    String saveDlrldBean(@Param("dlrldBean") DlrldBean dlrldBean, @Param("integral") Integer integral, @Param("houseId") Integer houseId);

    @Update("update house_dlrld set integralAdd=#{intee} where houseId=#{houseId} and status=1")
    void upupDlrldBean(@Param("dlrldBean") DlrldBean dlrldBean, @Param("intee") Integer intee, @Param("houseId") Integer houseId);

    @Select("select dt.*,di.dltypeName as integName from dlrld_type dt left join dltle_integral di on dt.prizeId=di.dltypeid")
    List<DlrldTypeBean> queryprize2();

    @Update("update house_dlrld set stateId=2 where stateId=1 and dlrIdId=#{dlrIdId}")
    void lingquTyped(Integer dlrIdId);

    @Update("update house_dlrld set stateId=3 where stateId=1 and dlrIdId=#{dlrIdId}")
    void fangqiTyped(Integer dlrIdId);

    @Select("select * from dlrld_type where dlrldtyId = #{dlrldtyId}")
    DlrldTypeBean querytype(Integer dlrldtyId);

    @Update("update house_dlrld set integralAdd=integralAdd+#{integralAdd/10} where stateId=1 and dlrIdId=#{houseId}")
    void UpMembershipPoint(Integer houseId, Integer integralAdd);

    int findUserCount(@Param("dlrldBean") DlrldBean dlrldBean);

    List<DlrldBean> findUserPage(@Param("start") int start, @Param("rows") Integer rows, @Param("dlrldBean") DlrldBean dlrldBean);
}
