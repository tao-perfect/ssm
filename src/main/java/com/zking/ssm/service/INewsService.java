package com.zking.ssm.service;

import com.zking.ssm.model.News;

import java.util.List;

public interface INewsService {
    /**
     * 查询所有新闻所对应的新闻类型
     * @return
     */
    List<News> queryNewsManyToMany();
    int deletenewsCategory(News news);
}