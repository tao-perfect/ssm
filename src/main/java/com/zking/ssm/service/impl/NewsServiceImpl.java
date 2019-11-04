package com.zking.ssm.service.impl;

import com.zking.ssm.mapper.NewsMapper;
import com.zking.ssm.model.News;
import com.zking.ssm.service.INewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class NewsServiceImpl implements INewsService {
    @Autowired
   private NewsMapper newsMapper;
    @Override
    public List<News> queryNewsManyToMany() {
        return newsMapper.queryNewsManyToMany();
    }

    @Override
    public int deletenewsCategory(News news) {
        return newsMapper.deletenewsCategory(news);
    }
}
