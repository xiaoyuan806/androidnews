package com.example.news.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.news.entity.News;
import com.example.news.utils.result;
import com.example.news.utils.upresult;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface NewsService extends IService<News> {
    public upresult upload(MultipartFile multipartFile);

    public result insert(News news);


    public List<News> listall();

}
