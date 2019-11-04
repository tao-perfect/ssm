package com.zking.ssm.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zking.ssm.model.Book;
import com.zking.ssm.service.IBookService;
import com.zking.ssm.util.PageBean;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

public class BookServiceImplTest {
    @Autowired
    private IBookService bookService;
    private Book book;
    @Before
    public void setUp() throws Exception {
        book=new Book();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void queryBookPager() {
        /*Book book = bookService.selectByPrimaryKey(170);
        System.out.println(book);
        System.out.println("-------------------");
        Book book1 = bookService.selectByPrimaryKey(170);
        System.out.println(book1);*/
        PageBean pageBean=new PageBean();
        /*if(null!=pageBean&&pageBean.isPagination()){
            PageHelper.startPage(pageBean.getPage(),pageBean.getRows());
        }*/
        List<Book> books = bookService.queryBookPager(book,pageBean);
        /*if(null!=pageBean&&pageBean.isPagination()){
             pageBean.setTotal(pageInfo.getTotal()+"");
        }*/
        System.out.println("总记录数："+pageBean.getTotal());
        for (Book book1 : books) {
            System.out.println(book1);
        }
    }
}