package com.example.news.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.news.entity.Memorandum;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MemorandumMapper extends BaseMapper<Memorandum> {
    public List<Memorandum> Selectmem(@Param("userid") int userid)throws Exception;
    public int insertmem(@Param("userid") int userid, @Param("content") String content, @Param("author") String author)throws Exception;
}
