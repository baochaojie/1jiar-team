package com.jk.mapper;

import com.jk.model.Login;
import com.jk.model.Resume;
import com.jk.model.Tree;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper {

    @Select("select r.*,j.jiaxidname as jiaxidname , y.jiaoyidname as jiaoyidname , h.hengyidname as hengyidname , s.shuozaiidname as shuozaiidname \n" +
            "from login_resume r \n" +
            "left join login_jiaxid j on r.jiaxid=j.id\n" +
            "left join login_jiaoyid y on r.jiaoyid=y.id\n" +
            "left join login_hengyid h on r.hengyid=h.id\n" +
            "left join login_shuozaiid s on r.shuozaiid=s.id")
    List<Resume> qureyResume();

    List<Tree> findTreeByPid(@Param("pid") int pid);


    void savelogin(Login login);

    @Select("select login,password from house_man where login=#{login}")
    Login login(Login login);

    @Select(" SELECT * FROM house_man  where login = #{value} ")

    Login phoneVerification(String login);
}
