package com.zking.ssm.mapper;

import com.zking.ssm.model.NewsCateGory;

public interface NewsCateGoryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(NewsCateGory record);

    int insertSelective(NewsCateGory record);

    NewsCateGory selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(NewsCateGory record);

    int updateByPrimaryKey(NewsCateGory record);
}