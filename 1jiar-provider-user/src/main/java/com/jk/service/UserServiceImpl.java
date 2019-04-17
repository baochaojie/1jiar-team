package com.jk.service;

import com.jk.mapper.UserMapper;
import com.jk.model.Login;
import com.jk.model.Resume;
import com.jk.model.Tree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;

@Controller
public class UserServiceImpl implements UserService{

    @Autowired
    private UserMapper userMapper;

    @PostMapping("qureyResume")
    @ResponseBody
    public List<Resume> qureyResume(){
        return userMapper.qureyResume();
    }


    @PostMapping("findTree")
    @ResponseBody
    public List<Tree> findTree() {
        int pid=0;
        List<Tree> list = findNodes(pid);
        return list;
    }
    private List<Tree> findNodes(int pid) {
        List<Tree> list = userMapper.findTreeByPid(pid);
        for (Tree tree : list) {
            Integer id = tree.getId();
            List<Tree> nodes = findNodes(id);
            if(nodes.size()<=0){

                tree.setSelectable(true);
            }else{



                tree.setSelectable(false);
                tree.setNodes(nodes);
            }
        }
        return list;
    }

/**
    @Override
    public String login(Login login, HttpSession session) {
        Login queryUser =  userMapper.login(login);
        if (queryUser == null){
            return "1";
        }else if(!queryUser.getPassword().equals(login.getPassword())){
            return "2";
        }else{
            session.setAttribute("login",queryUser.getLogon());
            session.setAttribute("login",queryUser );
            return "0";
        }
    }


     *
     * @param login
     * @param imgcode
     * @param request
     * @return

    @Override
    public HashMap<String, Object> login1(Login login, String imgcode, HttpServletRequest request) {

            HashMap<String, Object> result = new HashMap<>();
            HttpSession session = request.getSession();
            String sessionCode = session.getAttribute("imgcode").toString();
            //判断验证码是否和session中的一致
            if(!imgcode.equals(sessionCode)){
                result.put("code", 1);
                result.put("msg", "验证码错误");
                return result;
            }
            //判断账号是否存在
            Login userlnfo = userMapper.UserLogin(login.getLogon());

            if(userlnfo==null){
                result.put("code", 2);
                result.put("msg", "账号不存在");
                return result;
            }
            //判断前台输入的密码和数据库中保存的密码是否一致
            String password = login.getPassword();
            if(!userlnfo.getPassword().equals(password)){
                result.put("code", 3);
                result.put("msg","密码不正确");
                return result;
            }
            //将用户信息保存到session中

            session.setAttribute(session.getId(),userlnfo);
            result.put("code", 0);
            session.setAttribute("user", userlnfo);
            result.put("msg","登录成功");
            return result;

        }

     */
}
