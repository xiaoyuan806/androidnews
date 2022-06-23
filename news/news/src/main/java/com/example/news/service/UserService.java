package com.example.news.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.news.entity.User;
import com.example.news.mapper.UserMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserService extends IService<User> {
    public User getlogin(String username,String password)throws Exception;
    public int insert(User user);
    public List<User> getTen() throws Exception;
    //修改密码
    public int update(User user) throws Exception;

}
