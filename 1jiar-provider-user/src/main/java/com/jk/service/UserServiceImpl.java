package com.jk.service;

import com.jk.mapper.UserMapper;
import com.jk.model.*;
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
    public List<jiaoyid> selectjiaoyid() {
        return userMapper.selectjiaoyid();    }

    @Override
    public List<hengyid> selecthengyid() {
        return userMapper.selecthengyid();
    }

    @Override
    public List<shuozaiid> selectshuozaiid() {
        return userMapper.selectshuozaiid();
    }

    @Override
    public List<shuosiname> shuosiname(Integer pid) {
        return userMapper.shuosiname(pid);
    }

    @Override
    public List<jiaxid> jiaxidname() {
        return userMapper.jiaxidname();

    }

    @Override
    public List<jiaoxi> jiaoxidname(Integer pid) {
        return userMapper.jiaoxidname(pid);

    }

    @Override
    public void addOwner(Resume resume) {
         userMapper.addOwner(resume);
    }

    @Override
    public void deleteuser(Integer id) {
        userMapper.deleteuser(id);

    }

    @Override
    public List<zenghe> zenghe() {
        int pid=0;
        List<zenghe> list = findNode(pid);
        return list;
    }

    @Override
    public Login phoneVerificat(String login) {
        return userMapper.phoneVerificat(login);
    }

    private List<zenghe> findNode(int pid) {
        List<zenghe> list = userMapper.findTreeByP(pid);
        for (zenghe tree : list) {
            Integer id = tree.getId();
            List<zenghe> nodes = findNode(id);
            if(nodes.size()<=0){

                tree.setSelectable(true);
            }else{



                tree.setSelectable(false);
                tree.setNodes(nodes);
            }
        }
        return list;
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
