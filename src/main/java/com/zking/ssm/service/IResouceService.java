package com.zking.ssm.service;

import com.zking.ssm.model.Resouce;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IResouceService {

    List<Resouce> queryResoucePager();
}