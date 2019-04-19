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

    List<Tree> findTreeByPid(@Param("pid") int pid);


    void savelogin(Login login);

    @Select("select login,password from house_man where login=#{login}")
    Login login(Login login);


}
