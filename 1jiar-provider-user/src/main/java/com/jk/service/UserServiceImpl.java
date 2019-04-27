package com.jk.service;

import com.jk.mapper.UserMapper;
import com.jk.model.Login;
import com.jk.model.Resume;
import com.jk.model.Tree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<Resume> qureyResume(){
        return userMapper.qureyResume();
    }

    @Override
    public Integer savelogin(Login login) {
        userMapper.savelogin(login);
       return 1;
    }

    @Override
    public String login(Login login) {
        Login queryUser =  userMapper.login(login);
        if (queryUser == null){
            return "1";
        }else if(!queryUser.getPassword().equals(login.getPassword())){
            return "2";
        }else{
            return "0";
        }

    }

    @Override
    public Login phoneVerification(String login) {
        return userMapper.phoneVerification(login);

    }


    @Override
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




}
