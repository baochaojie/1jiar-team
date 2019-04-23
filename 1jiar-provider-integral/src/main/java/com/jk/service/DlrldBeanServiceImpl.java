package com.jk.service;

import com.jk.mapper.DlrldBeanMapper;
import com.jk.model.DlrldBean;
import com.jk.model.DlrldIntegrelBean;
import com.jk.model.DlrldTypeBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

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
        System.out.println(list);
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
        List range = redisTemplate.opsForList().range("QueryMembershipPoint" + houseId, 0, -1);
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
    public String saveDlrldBean(DlrldBean dlrldBean,Integer intee, Integer integral) {
                   dlrldBeanMapper.upupDlrldBean(dlrldBean,intee);
            return dlrldBeanMapper.saveDlrldBean(dlrldBean,integral);

        }

    @Override
    public DlrldTypeBean querytype(Integer dlrldtyId) {
        DlrldTypeBean list = dlrldBeanMapper.querytype(dlrldtyId);
        return list;
    }

    @Override
    public List<DlrldTypeBean> queryprize2() {
        return dlrldBeanMapper.queryprize2();
    }

    @Override
    public void lingquTyped(Integer dlrIdId,Integer houseId) {
        dlrldBeanMapper.lingquTyped(dlrIdId);
        redisTemplate.delete("queryDlrld" + houseId);
    }

    @Override
    public void fangqiTyped(Integer dlrIdId, Integer houseId) {
        dlrldBeanMapper.fangqiTyped(dlrIdId);
        redisTemplate.delete("queryDlrld" + houseId);
    }

}
