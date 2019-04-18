package com.jk.service;

        import com.jk.model.DlrldBean;
        import com.jk.model.DlrldIntegrelBean;
        import com.jk.model.DlrldTypeBean;

        import java.util.List;

public interface DlrldBeanService {

    List<DlrldBean> queryDlrld(Integer houseId);

    List<DlrldBean> QueryMembershipPoint();

    List<DlrldTypeBean> queryprize();

    List<DlrldIntegrelBean> typelist();

    void saveprize(DlrldTypeBean dlrldTypeBean);

    void deleteTyped(Integer ids);

    DlrldBean querydlrldId(Integer houseId);
}
