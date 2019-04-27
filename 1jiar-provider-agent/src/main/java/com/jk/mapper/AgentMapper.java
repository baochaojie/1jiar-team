package com.jk.mapper;

import com.jk.model.*;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

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

    List<AgentBean> findExhibition(Integer agentId);

    List<DictionaryTable> queryTree(Integer pid);

    void addProblemInfoById(Problem problem);

    List<Problem> findProblem();

    List<House> findEcharts();

    AgentBean findAgents(@Param("id")String id);
@Select("select * from t_area where pid=#{pid} ")
    List<Area> queryArea(Integer pid);
@Select("select a.* from t_agent a \n" +
        "left join t_area a1 on a.street=a1.id\n" +
        "left join t_area a2 on a2.pid=a1.id where a2.id=#{value}")
List<AgentBean> findAgents2(Integer id);
}
