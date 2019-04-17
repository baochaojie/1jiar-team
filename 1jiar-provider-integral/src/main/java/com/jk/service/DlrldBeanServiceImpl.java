package com.jk.service;

import com.jk.mapper.DlrldBeanMapper;
import com.jk.model.DlrldBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DlrldBeanServiceImpl implements DlrldBeanService{

    @Autowired
    private DlrldBeanMapper dlrldBeanMapper;

    @Override
    public List<DlrldBean> queryDlrld(Integer houseId) {
        List<DlrldBean> list =  dlrldBeanMapper.queryDlrld(houseId);
        return list;
    }
}
