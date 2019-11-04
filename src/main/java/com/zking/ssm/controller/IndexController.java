package com.zking.ssm.controller;

import com.zking.ssm.model.Book;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Locale;
import java.util.Map;

@Controller
public class IndexController {

//    实例一：@RequestMapping作用在方法上
//    实例二：@RequertMapping作用在类上
//    实例三：@RequestMapping之method请求方式POST+GET
//    实例四：接收请求参数：@RequestParam、String、对象、HttpServletRequst以及Map
//    实例伍：返回结果
//    1)返回逻辑视图名，用于跳转页面
//    2）ModelAndView模型视图
//    实例六：页面跳转
//    1）forward:path  转发   路径不会变   请求一次    数据共享
//    2)redirect:path  重定向  路径变化   请求两次  数据不共享

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String toIndex(@RequestParam String sex, Book book,
                                HttpServletRequest request,
                          Map map,Model model){
        System.out.println("index");
        System.out.println("sex="+sex);
        System.out.println(book);
        System.out.println(request);
        System.out.println(map);

//        ModelAndView mv=new ModelAndView();
//        mv.setViewName("index");
//        mv.addObject("book",book);
        model.addAttribute("book",book);
                return "redirect:toHome";
//    return mv
          }
          @RequestMapping("/toHome")
          public String toHome(){
              System.out.println("toHome");
              return "index";
          }

    @RequestMapping("/home/index.shtml")
    public String toWelcome(){
//        System.out.println("welcome");
        return "login";
        }
    @RequestMapping("/changeLocale")
        public String changeLocale(HttpSession session, @RequestParam String locale){
        if("en".equals(locale))
            session.setAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME, Locale.US);
        else
            session.setAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME,Locale.CHINA);
        return "index";
        }
    }
