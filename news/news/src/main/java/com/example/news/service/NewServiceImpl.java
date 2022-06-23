package com.example.news.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.news.entity.News;
import com.example.news.mapper.NewsMapper;
import com.example.news.mapper.UserMapper;
import com.example.news.utils.result;
import com.example.news.utils.upresult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
public class NewServiceImpl extends ServiceImpl<NewsMapper, News>implements NewsService {
    @Resource
    private NewsMapper newsMapper;
    @Override
    public upresult upload(MultipartFile multipartFile) {
       if(multipartFile.isEmpty()){
           return new upresult(400,"文件为空",null);
       }
       String OringinName=multipartFile.getOriginalFilename();
       String filename=OringinName;
        File file=new File("D:\\work\\ssm\\news\\nginx-1.18.0\\image",filename);
        try {
            multipartFile.transferTo(file);
        } catch (IOException e) {
            e.printStackTrace();
        }


        return new upresult(200,"上传成功","http://192.168.43.72:80/"+filename);
    }


    public result insert(News news) {
      int res= newsMapper.insert(news);

      if (res!=0){
          return new result(true,null);
      }
        return new result(false,null);
    }




    @Override
    public List<News> listall() {
        return newsMapper.listall();
    }
}
