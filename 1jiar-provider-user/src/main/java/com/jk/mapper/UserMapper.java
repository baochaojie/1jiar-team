package com.jk.mapper;

import com.jk.model.Login;
import com.jk.model.Resume;
import com.jk.model.Tree;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper {
    @Select("select * from login_resume ")
    List<Resume> qureyResume();

    List<Tree> findTreeByPid(int pid);

    @Select("select * from login l where l.logon=#{value}")
    int findCount(String logon);

    /**
     *
     * @param login
     * @return

    Login login(Login login);

    @Select("select l.logon,l.password from login l where l.logon=#{logon}")
    Login UserLogin(String logon);

     */
}
