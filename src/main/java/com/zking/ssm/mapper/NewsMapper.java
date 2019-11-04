package com.zking.ssm.mapper;

import com.zking.ssm.model.News;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface NewsMapper {
    /**
     * 查询所有新闻所对应的新闻类型
     * @return
     */
    List<News> queryNewsManyToMany();
    int deletenewsCategory(News news);
}