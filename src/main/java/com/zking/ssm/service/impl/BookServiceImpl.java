package com.zking.ssm.service.impl;

import com.github.pagehelper.Page;
import com.zking.ssm.mapper.BookFileMapper;
import com.zking.ssm.mapper.BookMapper;
import com.zking.ssm.model.Book;
import com.zking.ssm.model.BookFile;
import com.zking.ssm.service.IBookService;
import com.zking.ssm.util.PageBean;
import com.zking.ssm.vo.BookFileVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

//@Transactional
@Service
public class BookServiceImpl implements IBookService {
//   @Resource(name = "bookMapper")
    @Autowired
    private BookMapper bookMapper;
    @Autowired
    private BookFileMapper bookFileMapper;

    @Override
    public Book selectByPrimaryKey(Integer id) {
        return bookMapper.selectByPrimaryKey(id);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Book> queryBookPager(Book book, PageBean pageBean) {
        return bookMapper.queryBookPager(book);
    }
    @Override
    public int insert(Book record) {
        return bookMapper.insert(record);
    }
//    执行多条sql语句
    @Override
    public int updateBookImage(Book book, BookFileVo bookFileVo) {
        bookMapper.updateBookImage(book);
        bookFileMapper.insert(bookFileVo);
        return 1;
    }

    @Override
    public Map queryByMap() {
        return bookMapper.queryByMap();
    }

    @Override
    public List<Map> queryByListMap() {
        return bookMapper.queryByListMap();
    }
}
