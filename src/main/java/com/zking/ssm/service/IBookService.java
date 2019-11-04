package com.zking.ssm.service;

import com.zking.ssm.model.Book;
import com.zking.ssm.util.PageBean;
import com.zking.ssm.vo.BookFileVo;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

public interface IBookService {
    Book selectByPrimaryKey(Integer id);
    List<Book> queryBookPager(Book book, PageBean pageBean);
    int insert(Book record);
    int updateBookImage(Book book, BookFileVo bookFileVo);
    Map queryByMap();
    List<Map> queryByListMap();
}