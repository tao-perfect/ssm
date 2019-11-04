package com.zking.ssm.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//@RestController=@Controller+@ResponseBody
@RestController
@RequestMapping(value = "/test")
public class Testcontroller {
    @RequestMapping("/queryTest")
    public String queryTest(){
        return "book/bookAdda";
    }
}
