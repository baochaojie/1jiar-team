package com.jk.service;


import com.jk.model.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;


public interface UserService {

    List<Tree> findTree();

    List<Resume> qureyResume();

    Integer savelogin(Login login);

    String login(Login login);

    Login phoneVerification(String login);

    List<jiaoyid> selectjiaoyid();

    List<hengyid> selecthengyid();

    List<shuozaiid> selectshuozaiid();

    List<shuosiname> shuosiname(Integer pid);

    List<jiaxid> jiaxidname();

    List<jiaoxi> jiaoxidname(Integer pid);

    void addOwner(Resume resume);

    void deleteuser(Integer id);

    List<zenghe> zenghe();
}
