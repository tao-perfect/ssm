package com.zking.ssm.mapper;

import com.zking.ssm.model.Resouce;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ResouceMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Resouce record);

    int insertSelective(Resouce record);

    Resouce selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Resouce record);

    int updateByPrimaryKey(Resouce record);
    @Select("SELECT * FROM t_sys_resource WHERE STATUS=1 ORDER BY sortnum")
    List<Resouce> queryResoucePager();
}