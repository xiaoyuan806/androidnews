package com.example.news.controller;


import com.example.news.entity.Memorandum;

import com.example.news.service.MemorandumService;
import com.example.news.utils.result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/Memorandum")
public class MemorandumController {
    @Autowired
    private MemorandumService memorandumService;
    @RequestMapping("/Select")
    public List<Memorandum> Selectmem(@RequestBody Memorandum memorandum) throws Exception {
        System.out.print("收到");

        List<Memorandum> memorandum1= memorandumService.Selectmem(memorandum);
//        System.out.print(memorandum1.()+"   "+memorandum1.getAuthor()+"    "+memorandum1.getContent());
        for (int i = 0; i < memorandum1.size(); i++) {
            System.out.println(((Memorandum)memorandum1.get(i)).getAuthor());
        }

        return memorandum1;
    }
    //修改密码
    @RequestMapping("/insert")
    public result insertmem(@RequestBody Memorandum memorandum) throws Exception {
        System.out.println("收到!!!");
        Memorandum memorandum1=new Memorandum();
        memorandum1.setUserid(memorandum.getUserid());
        memorandum1.setAuthor(memorandum.getAuthor());
        memorandum1.setContent(memorandum.getContent());
        System.out.print(memorandum1.getUserid()+"    "+memorandum1.getAuthor()+"  "+memorandum1.getContent());
        result res;
        int resId=memorandumService.insertmem(memorandum1);
        if (resId!=0){
            return new result(true,null);
        }
        return new result(false,null);
      }
    }
