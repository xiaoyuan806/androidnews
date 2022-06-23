package com.example.news.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.example.news.entity.Memorandum;
import com.example.news.mapper.MemorandumMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MemorandumServiceImpl extends ServiceImpl<MemorandumMapper, Memorandum> implements MemorandumService {
    @Resource
    private MemorandumMapper memorandumMapper;
    @Override
    public List<Memorandum> Selectmem(Memorandum memorandum) throws Exception {
        List<Memorandum> memorandum1;
        memorandum1= memorandumMapper.Selectmem(memorandum.getUserid());
        return memorandum1;
    }
    @Override
    public int insertmem(Memorandum memorandum)throws Exception{
        int flag=memorandumMapper.insertmem(memorandum.getUserid(),memorandum.getContent(),memorandum.getAuthor());
        return flag;
    }
}
