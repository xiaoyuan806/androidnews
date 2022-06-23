package com.example.news.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.news.entity.Memorandum;


import java.util.List;

public interface MemorandumService extends IService<Memorandum> {
    public List<Memorandum> Selectmem(Memorandum memorandum)throws Exception;
    public int insertmem(Memorandum memorandum)throws Exception;
}