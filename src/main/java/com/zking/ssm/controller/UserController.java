package com.zking.ssm.controller;

import com.zking.ssm.model.SysUser;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {
    @RequestMapping("/userLogin")
    public String userLogin(SysUser sysUser, Model model){
        String username=sysUser.getUsername();
        String password=sysUser.getPassword();

        //获取主体
        Subject subject = SecurityUtils.getSubject();
        //创建用户密码Token
        UsernamePasswordToken token=new UsernamePasswordToken(
                username,password
        );
        token.setRememberMe(true);
        String message=null;
        try {
            subject.login(token);
        } catch (IncorrectCredentialsException e) {
            e.printStackTrace();
            message="密码错误";
        }catch (UnknownAccountException e){
            e.printStackTrace();
            message="账号错误";
        }catch (Exception e){
            e.printStackTrace();
            message="账号或密码错误";
        }
        if(null==message){
            return "index";
        }else{
            model.addAttribute("message",message);
            return "login";
        }
    }
    @RequestMapping("/logout")
    public String logout(){
        //关键代码
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return "redirect:/home/index.shtml";
    }
}
