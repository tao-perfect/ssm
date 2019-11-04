package com.zking.ssm.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.tracing.dtrace.ModuleAttributes;
import com.zking.ssm.model.Book;
import com.zking.ssm.model.BookType;
import com.zking.ssm.service.IBookService;
import com.zking.ssm.util.PageBean;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

@Controller
@RequestMapping(value = "/book")
public class BookController {

    @Autowired
    public IBookService bookService;
//预先加载数据用ModelAttribute
    @ModelAttribute
    public void init(Model model){
        Book book=new Book();
        model.addAttribute("book",book);

//        提交初始化相关数据
        List<BookType> lst=new ArrayList<>();
        lst.add(new BookType(1,"著作"));
        lst.add(new BookType(2,"文学"));
        lst.add(new BookType(3,"经典"));
        model.addAttribute("btype",lst);
    }

    @RequestMapping("/toAdd")
    public String toAdd(){
        return "book/bookAdd";
    }
    @RequestMapping("/toBookFile")
    public String toBookFiles(@RequestParam Integer id){
        return "book/bookUpload";
}
    @RequestMapping("/toList")
    public String toList(){
        return "book/bookList";
    }
    @RequestMapping("/addBook")
    public String addBook(@Validated(value = {Book.ValidateGroups.Edit.class}) @ModelAttribute Book book, BindingResult bindingResult){
//        服务器端验证不通过
        if(bindingResult.hasErrors()){
            //非验证信息
            //bindingResult.rejectValue("bookname",null,"书本可以为空");
            return "book/bookAdd";
        }else{
            bookService.insert(book);
            System.out.println("添加成功");
            return "redirect:queryBookPager";
        }
    }
    @RequestMapping("/queryBookPager")
    public ModelAndView queryBookPager(HttpServletRequest request,Book book){
        PageBean pageBean=new PageBean();
        pageBean.setRequest(request);
        List<Book> books=bookService.queryBookPager(book,pageBean);
        ModelAndView mv=new ModelAndView();
        mv.setViewName("book/bookList");
        mv.addObject("pageBean",pageBean);
        mv.addObject("books",books);
        return mv;
    }
   /* @RequestMapping(value = "/queryBookPager",method = RequestMethod.POST)
    @ResponseBody
    public void queryBookPager(HttpServletRequest request, HttpServletResponse response, @RequestBody Map<String,String> getData,Book book){
        PageBean pageBean=new PageBean();
        pageBean.setRequest(request);
        book.setBookname(getData.get("bookname"));
        List<Book> books=bookService.queryBookPager(book,pageBean);

        ObjectMapper mapper=new ObjectMapper();
        Map<String,Object> json=new HashMap<String,Object>();
        json.put("success",true);
        json.put("msg", books);
        try {
            mapper.writeValue(response.getOutputStream(), json);
        } catch (IOException e) {
            e.printStackTrace();
        }
        *//*
        //        return books;
        ModelAndView mv=new ModelAndView();
        mv.setViewName("book/bookList");
        mv.addObject("pageBean",pageBean);
        mv.addObject("books",books);
        return mv;*//*
    }*/
    //查询返回JSON
    @RequiresRoles( value = "管理员")
    @RequestMapping("/queryListJSON")
    @ResponseBody
   public List<Book> queryListJSON(HttpServletRequest request,Book book){
       PageBean pageBean=new PageBean();
       pageBean.setRequest(request);
       List<Book> books=bookService.queryBookPager(book,pageBean);
       return books;
   }
   /*
   错误示范
    这个返回的是JSON串
   */
    @RequestMapping("/test")
    @ResponseBody
    public String test(){
        return "book/bookAdd";
    }
    @RequestMapping("/queryMapListJson")
    @ResponseBody
    public List<Map> queryMapListJson(){
        List<Map> maps = bookService.queryByListMap();
        return maps;
    }
    @RequestMapping("/querySingleBookJson")
    @ResponseBody
    public Book querySingleBookJson(){
        Book book = bookService.selectByPrimaryKey(170);
        book.setCreatedate(new Date());
        return book;
    }
    @RequiresPermissions("bookmanager:book:edit")
    @RequestMapping("/queryMapJson")
    @ResponseBody
    public Map queryMapJson(){
        Map map = bookService.queryByMap();
        return map;
    }
}
