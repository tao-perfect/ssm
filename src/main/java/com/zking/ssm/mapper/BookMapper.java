package com.zking.ssm.mapper;

import com.zking.ssm.model.Book;
import com.zking.ssm.vo.BookFileVo;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface BookMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Book record);

    int insertSelective(Book record);

    Book selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Book record);

    int updateByPrimaryKey(Book record);

    List<Book> queryBookPager(Book book);

    int updateBookImage(Book book);

    Map queryByMap();

    List<Map> queryByListMap();
}