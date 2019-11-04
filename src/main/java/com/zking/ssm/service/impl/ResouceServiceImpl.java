package com.zking.ssm.service.impl;

import com.zking.ssm.mapper.ResouceMapper;
import com.zking.ssm.model.Resouce;
import com.zking.ssm.service.IResouceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ResouceServiceImpl implements IResouceService {
    @Autowired
    private ResouceMapper resouceMapper;
    @Override
    public List<Resouce> queryResoucePager() {
        return resouceMapper.queryResoucePager();
    }
}
