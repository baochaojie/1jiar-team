package com.jk.mapper;

import com.jk.model.*;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserMapper {


    List<Tree> findTreeByPid(@Param("pid") int pid);


    void savelogin(Login login);

    @Select("select login,password from house_man where login=#{login}")
    Login login(Login login);

    @Select(" SELECT * FROM house_man  where login = #{value} ")
    Login phoneVerification(String login);

    @Select("select * from login_jiaoyid")
    List<jiaoyid> selectjiaoyid();

    @Select("select * from login_hengyid")
    List<hengyid> selecthengyid();

    @Select("select * from login_shuozaiid")
    List<shuozaiid> selectshuozaiid();

    @Select("select * from login_shuosiname s where s.pid=#{value}")
    List<shuosiname> shuosiname(Integer pid);

    @Select("select * from login_jiaxid")
    List<jiaxid> jiaxidname();

    @Select("select * from login_jiaoxidname j where j.pid=#{value}")
    List<jiaoxi> jiaoxidname(Integer pid);

    @Insert("insert into house_man(namea,jiaxid,jiaoxid,xingb,aihao,jiaoyid,hengyid,shuozaisiid,shuozaiid) values(#{namea},#{jiaxid},#{jiaoxid},#{xingb},#{aihao},#{jiaoyid},#{hengyid},#{shuozaisiid},#{shuozaiid})")
    void addOwner(Login resume);

    @Delete("DELETE from house_man where id=#{id}")
    void deleteuser(Integer id);

    List<zenghe> findTreeByP(@Param("pid") int pid);

   /* @Select(" SELECT * FROM house_man  where login = #{value} ")
    Login phoneVerificat(String login);*/

    int findHouseCount(@Param("house") House house);

    List<House> findHousePage(@Param("start") int start, @Param("rows") Integer rows, @Param("house") House house);

    @Select(" select houseTeSeName from  house_feature  where houseTeSeId =#{value}")
    String featurenamebyid(int teSeId);

    @Select("select * from house_man ")
    List<Login> inituserphone();
    @Delete("Delete from t_house where houseId=#{houseId}")
    void deleteshouc(Integer houseId);

    int qureyCount(@Param("login") Login login);

    List<Login> qureyResume(@Param("start") int start,@Param("rows") Integer rows,@Param("login") Login login);

    @Select("select m.id ,m.login, m.password from house_man m where m.id=#{value}")
    Login queryhunx(Integer id);

    @Update("update house_man set login=#{login},password=#{password},namea=#{namea},jiaxid=#{jiaxid},jiaoxid=#{jiaoxid},xingb=#{xingb},aihao=#{aihao},jiaoyid=#{jiaoyid},hengyid=#{hengyid},shuozaisiid=#{shuozaisiid},shuozaiid=#{shuozaiid} where id=#{id}")

    void updatewner(Login resume);
}
