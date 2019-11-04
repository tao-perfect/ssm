package com.zking.ssm.service.impl;

import com.zking.ssm.model.News;
import com.zking.ssm.service.INewsService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.*;

public class NewsServiceImplTest extends BaseTest{
    @Autowired
    private INewsService newsService;
    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void queryNewsManyToMany() {
        List<News> news = newsService.queryNewsManyToMany();
        for (News news1 : news) {
            System.out.println(news1);
        }
    }
}