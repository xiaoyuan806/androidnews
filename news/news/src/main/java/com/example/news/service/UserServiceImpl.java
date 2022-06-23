package com.example.news.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.news.entity.User;
import com.example.news.mapper.UserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Resource
    private UserMapper userMapper;


    @Override
    public User getlogin(String username, String password) throws Exception {

            User user=new User();
            user=userMapper.getlogin(username,password);
            return user;

    }

    @Override
    public int insert(User user) {
       int flag=userMapper.insert(user);
        return flag;
    }

    @Override
    public List<User> getTen() throws Exception {
        List<User> list;
        list=userMapper.getTen();
        return list;
    }
    //修改密码
    @Override
    public int update(User user) throws Exception{
        int flag=userMapper.update(user.getId(),user.getPassword());
        return flag;
    };
}
