package com.jk.service;


import com.jk.model.Login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;

public interface UserService {

    /**
     *
     * @param login
     * @param session
     * @return

    String login(Login login, HttpSession session);

    HashMap<String, Object> login1(Login login, String imgcode, HttpServletRequest request);
     */
}
