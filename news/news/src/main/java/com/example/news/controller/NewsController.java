package com.example.news.controller;

import com.example.news.entity.News;
import com.example.news.entity.User;
import com.example.news.service.NewsService;
import com.example.news.utils.result;
import com.example.news.utils.upresult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/News")
public class NewsController {
    @Autowired
    private NewsService newsService;

    private upresult upresult;

    @RequestMapping("/add")
    public upresult addnews(@RequestParam("file")MultipartFile multipartFile){
      upresult= newsService.upload(multipartFile);

         return upresult;
     }
     @RequestMapping("/addnew")
     public result addnew(@RequestBody News news){
        result result=newsService.insert(news);
        return result;
     }



    @RequestMapping("/listall")
    public List<News> listall() throws Exception {
        List<News> list=newsService.listall();
        return list;
    }




}
