package com.zking.ssm.service.impl;

import com.zking.ssm.model.Resouce;
import com.zking.ssm.service.IResouceService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.*;

public class ResouceServiceImplTest extends BaseTest{
    @Autowired
    private IResouceService resouceService;
    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void queryResoucePager() {
        List<Resouce> resouces = resouceService.queryResoucePager();
        for (Resouce resouce : resouces) {
            System.out.println(resouce);
        }
    }
}