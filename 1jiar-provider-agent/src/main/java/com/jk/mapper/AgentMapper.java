package com.jk.mapper;

import com.jk.model.AgentBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AgentMapper {
    Integer findCountAgent(@Param("agentBean") AgentBean agentBean);
    List<AgentBean> findAgent(@Param("start") Integer start,@Param("rows") Integer rows,@Param("agentBean") AgentBean agentBean);

    void saveAgent(AgentBean agentBean);

    List<AgentBean> findRegion(Integer id);
}
