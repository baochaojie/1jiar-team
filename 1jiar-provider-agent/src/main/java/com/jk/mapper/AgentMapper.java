package com.jk.mapper;

import com.jk.model.AgentBean;
import com.jk.model.House;
import com.jk.model.LabelBean;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;

public interface AgentMapper {
    Integer findCountAgent(@Param("agentBean") AgentBean agentBean);
    List<AgentBean> findAgent(@Param("start") Integer start,@Param("rows") Integer rows,@Param("agentBean") AgentBean agentBean);

    void saveAgent(AgentBean agentBean);

    List<AgentBean> findRegion(Integer id);

    AgentBean findAgentInfoById(Integer agentId);

    int deleteAgent(Integer[] ids);

    Integer findCommentCount(Integer agentId);

    List<House> findHouse();

    List<LabelBean> findLabel();
}
