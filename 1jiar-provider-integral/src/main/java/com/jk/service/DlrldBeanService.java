package com.jk.service;

        import com.jk.model.DlrldBean;
        import com.jk.model.DlrldIntegrelBean;
        import com.jk.model.DlrldTypeBean;

        import java.util.HashMap;
        import java.util.List;

public interface DlrldBeanService {

    //查询历史中奖纪录
    List<DlrldBean> queryDlrld(Integer houseId);

    //后台查询历史中奖纪录
    HashMap<String, Object> queryDlrldht(Integer page, Integer rows, DlrldBean dlrldBean);

    //查询用户积分余额
    List<DlrldBean> QueryMembershipPoint(Integer houseId);

    //查询奖品 redis
    List<DlrldTypeBean> queryprize(Integer dltypeid);

    //查询奖品级别 redis
    List<DlrldIntegrelBean> typelist();

    void saveprize(DlrldTypeBean dlrldTypeBean);

    void deleteTyped(Integer ids);

    DlrldBean querydlrldId(Integer houseId);
    
    List<DlrldTypeBean> queryprize2();

    void lingquTyped(Integer dlrIdId, Integer houseId);

    void fangqiTyped(Integer dlrIdId, Integer houseId);

    String saveDlrldBean(DlrldBean dlrldBean, Integer intee, Integer integral, Integer houseId);

    DlrldTypeBean querytype(Integer dlrldtyId);

    void UpMembershipPoint(Integer houseId, Integer integralAdd);
}
