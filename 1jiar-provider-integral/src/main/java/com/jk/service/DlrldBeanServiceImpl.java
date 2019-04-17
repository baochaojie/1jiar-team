package com.jk.service;

import com.jk.mapper.DlrldBeanMapper;
import com.jk.model.DlrldBean;
import com.jk.model.DlrldIntegrelBean;
import com.jk.model.DlrldTypeBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DlrldBeanServiceImpl implements DlrldBeanService{

    @Autowired
    private DlrldBeanMapper dlrldBeanMapper;

    @Override
    public List<DlrldBean> queryDlrld(Integer houseId) {
        return dlrldBeanMapper.queryDlrld(houseId);
    }

    @Override
    public List<DlrldBean> QueryMembershipPoint() {
        return dlrldBeanMapper.QueryMembershipPoint();
    }

    @Override
    public List<DlrldTypeBean> queryprize() {
        return dlrldBeanMapper.queryprize();
    }

    @Override
    public List<DlrldIntegrelBean> typelist() {
        return dlrldBeanMapper.typelist();
    }

    @Override
    public void saveprize(DlrldTypeBean dlrldTypeBean) {
        dlrldBeanMapper.saveprize(dlrldTypeBean);
    }

    @Override
    public void deleteTyped(Integer ids) {
         dlrldBeanMapper.deleteTyped(ids);
    }

    @Override
    public DlrldBean querydlrldId(Integer houseId) {
        return dlrldBeanMapper.querydlrldId(houseId);
    }
}
