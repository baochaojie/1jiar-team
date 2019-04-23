package com.jk.mapper;

import com.jk.model.*;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserMapper {

    @Select("select r.*,j.jiaxidname as jiaxidname , y.jiaoyidname as jiaoyidname , h.hengyidname as hengyidname , s.shuozaiidname as shuozaiidname ,\n" +
            "           o.jiaoxidname as jiaoxidname ,  n.shuosiname as shuosiname\n" +
            "            from login_resumen r \n" +
            "            left join login_jiaxid j on r.jiaxid=j.id\n" +
            "            left join login_jiaoyid y on r.jiaoyid=y.id\n" +
            "            left join login_hengyid h on r.hengyid=h.id\n" +
            "            left join login_shuozaiid s on r.shuozaiid=s.id\n" +
            "\t\t\t\t\t\tleft join login_jiaoxidname o on r.jiaoxid=o.id\n" +
            "\t\t\t\t\t\tleft join login_shuosiname n on r.shuozaisiid=n.id")
    List<Resume> qureyResume();

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

    @Insert("insert into login_resumen(name,jiaxid,jiaoxid,xingb,aihao,jiaoyid,hengyid,shuozaisiid,shuozaiid) values(#{name},#{jiaxid},#{jiaoxid},#{xingb},#{aihao},#{jiaoyid},#{hengyid},#{shuozaisiid},#{shuozaiid})" )
    void addOwner(Resume resume);

    @Delete("DELETE from login_resumen where id=#{id}")
    void deleteuser(Integer id);

    List<zenghe> findTreeByP(@Param("pid")int pid);
}
