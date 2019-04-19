package com.jk.service;

import com.jk.mapper.DlrldBeanMapper;
import com.jk.model.DlrldBean;
import com.jk.model.DlrldIntegrelBean;
import com.jk.model.DlrldTypeBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class DlrldBeanServiceImpl implements DlrldBeanService{

    @Autowired
    private DlrldBeanMapper dlrldBeanMapper;

    @Autowired
    private RedisTemplate redisTemplate;

    //查询历史中奖纪录
    @Override
    public List<DlrldBean> queryDlrld(Integer houseId) {
        List<DlrldBean> range = redisTemplate.opsForList().range("queryDlrld" + houseId, 0, -1);
        if (range!=null && range.size()>0){
            List<DlrldBean> dlrldBean = (List<DlrldBean>) range.get(0);
            return dlrldBean;
        }
        List<DlrldBean> list = dlrldBeanMapper.queryDlrld(houseId);
        if (list==null){
            redisTemplate.opsForList().leftPush("queryDlrld"+houseId,list);
        }else{
            redisTemplate.opsForList().leftPush("queryDlrld"+houseId,list);
        }
        return list;
    }

    //查询用户积分余额
    @Override
    public List<DlrldBean> QueryMembershipPoint(Integer houseId) {
        List<DlrldBean> range = redisTemplate.opsForList().range("QueryMembershipPoint" + houseId, 0, -1);
        if (range != null && range.size() > 0){
            List<DlrldBean> dlrldBean = (List<DlrldBean>) range.get(0);
            return dlrldBean;
        }
        List<DlrldBean> list = dlrldBeanMapper.QueryMembershipPoint(houseId);
            if (list==null){
                redisTemplate.opsForList().leftPush("QueryMembershipPoint"+houseId,list);
            }else{
                redisTemplate.opsForList().leftPush("QueryMembershipPoint"+houseId,list);
            }
        return list;
    }

    //查询奖品 redis
    @Override
    public List<DlrldTypeBean> queryprize(Integer dltypeid) {
        List<DlrldTypeBean> list = dlrldBeanMapper.queryprize(dltypeid);
        System.out.println(list);
        return list;
    }

    //查询奖品级别 redis
    @Override
    public List<DlrldIntegrelBean> typelist() {
        List<DlrldIntegrelBean> typelist = redisTemplate.opsForList().range("typelist", 0, -1);
        if (typelist!=null && typelist.size()>0){
            List<DlrldIntegrelBean> dlrldIntegrelBean = (List<DlrldIntegrelBean>) typelist.get(0);
            return dlrldIntegrelBean;
        }
        List<DlrldIntegrelBean> list = dlrldBeanMapper.typelist();
        if (list==null) {
            redisTemplate.opsForList().leftPush("typelist", list);
        }else{
            redisTemplate.opsForList().leftPush("typelist", list);
        }
        return list;
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
        DlrldBean list = dlrldBeanMapper.querydlrldId(houseId);
        return list;
    }

    @Override
    public void saveDlrldBean(DlrldBean dlrldBean) {
        Integer intee = dlrldBean.getIntegralAdd();
        Integer integral = 0;
        if (dlrldBean.getPrizeTypeid()==1){
            integral=500;
            intee=intee-integral;
        }else if (dlrldBean.getPrizeTypeid()==2){
            integral=1000;
            intee=intee-integral;
        }else if (dlrldBean.getPrizeTypeid()==3){
            integral=3000;
            intee=intee-integral;
        }
        if(integral>=0){
            dlrldBeanMapper.saveDlrldBean(dlrldBean,integral);
            dlrldBeanMapper.upupDlrldBean(dlrldBean,intee);
        }
        }

}
