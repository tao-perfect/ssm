package com.zking.ssm.util;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Aspect
public class PageAspect {
    @Around(value="execution(* *..*Service.*Pager(..))")
    public Object invoke(ProceedingJoinPoint joinPoint) throws Throwable{
        //1.获取目标方法的执行的参数
        Object[] args=joinPoint.getArgs();
        //2.定义PageBean对象
        PageBean pageBean=null;
        //循环遍历参数
        for(Object arg : args){
            if(arg instanceof PageBean){
                pageBean =(PageBean)arg;
            }
        }

        //2.判断是否分页，并设置分页参数到pageHelper中
        if(null!=pageBean&&pageBean.isPagination()){
            PageHelper.startPage(pageBean.getPage(),pageBean.getRows());
        }

        //3.执行目标方法
        Object result=joinPoint.proceed(args);

        //4.获取分页信息
        if(null!=pageBean&&pageBean.isPagination()&&null!=result&&result instanceof List){
           List lst=(List)result;
            PageInfo pageInfo=new PageInfo(lst);
            pageBean.setTotal(pageInfo.getTotal()+"");
        }
        return result;
    }
}
