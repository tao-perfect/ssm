package com.zking.ssm.shiro;

import com.zking.ssm.model.Resouce;
import com.zking.ssm.service.IResouceService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class FilterChainDefinitionMap {
    @Autowired
    private IResouceService resouceService;
    public Map<String,String> builder(){
        Map<String,String> map=new LinkedHashMap<String,String>();
        List<Resouce> resouces = resouceService.queryResoucePager();
        for (Resouce resouce : resouces) {
            map.put(resouce.getKey(),resouce.getVal());
        }
       /* map.put("/user/userLogin","anon");
        map.put("/book/**","authc");
        map.put("/**","authc");*/
        return map;
    }
}
