package com.zking.ssm.mapper;

import com.zking.ssm.model.SysUser;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface SysUserMapper {
    SysUser userLogin(String username);
    //查询usernaem查询该用户的角色，用于角色验证
    Set<String> findRoles(String username);
    //查询username查询用户的权限，用于权限验证
    Set<String> findPermissions(String username);
}