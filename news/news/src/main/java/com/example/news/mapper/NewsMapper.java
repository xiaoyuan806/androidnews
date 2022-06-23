package com.example.news.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.news.entity.News;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Mapper
public interface NewsMapper extends BaseMapper<News> {
    public List<News> listall();

}
