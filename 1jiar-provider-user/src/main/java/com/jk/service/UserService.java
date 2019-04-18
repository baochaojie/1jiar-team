package com.jk.service;


import com.jk.model.Login;
import com.jk.model.Resume;
import com.jk.model.Tree;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;


public interface UserService {

    List<Tree> findTree();

    List<Resume> qureyResume();

    Integer savelogin(Login login);

    String login(Login login);

}
