package com.jk.mapper;

import com.jk.model.*;
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

    void updateAgent(AgentBean agentBean);

    List<Exhibition> findExhibition(Integer agentId);

    List<DictionaryTable> queryTree(Integer pid);

    void addProblemInfoById(Problem problem);

    List<Problem> findProblem();

    List<House> findEcharts();

}
