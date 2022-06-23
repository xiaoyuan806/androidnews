package com.example.news.controller;

import com.example.news.entity.User;
import com.example.news.mapper.UserMapper;
import com.example.news.service.UserService;
import com.example.news.utils.result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/User")
public class UserController {

    @Autowired
    private UserService userService;
@RequestMapping("/login")
    public result getlogin(@RequestBody User user) throws Exception {
    System.out.println("收到");
    result res;

    User userres=userService.getlogin(user.getUsername(),user.getPassword());

    if(userres!=null){
        res=new result(true,userres);
        return res;

    }
    res=new result(false,null);
    return res;
}
    @RequestMapping("/register")
   public result register(@RequestBody User user){
    User user1=new User();
    user1.setPassword(user.getPassword());
    user1.setUsername(user.getUsername());
    result res;
    if(user1.getPassword() == null||user1.getUsername()==null){
        return new result(false,null);
    }
    int resId=userService.insert(user1);
    if (resId!=0){
        return new result(true,null);
    }
    return new result(false,null);
   }

   @RequestMapping("/besTen")
   public List<User> bestTen() throws Exception {
    List<User> list=userService.getTen();
       System.out.println("十佳");
    return list;
   }
    //修改密码
    @RequestMapping("/update")
    public result update(@RequestBody User user) throws Exception {
        System.out.println("收到!!!");
        User user1=new User();
        user1.setPassword(user.getPassword());
        user1.setId(user.getId());
        System.out.println(user1.getId()+"   "+user1.getPassword());
        result res;
        int resId=userService.update(user1);
        if (resId!=0){
            return new result(true,null);
        }
        return new result(false,null);
    }

}
