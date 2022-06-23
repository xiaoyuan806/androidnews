package com.example.news.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.news.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper extends BaseMapper<User> {

    public User getlogin(@Param("username")String username,@Param("password")String password)throws Exception;
    public List<User> getTen()throws Exception;
    //修改密码
    public int update(@Param("id")Long id,@Param("password")String password)throws Exception;
}
