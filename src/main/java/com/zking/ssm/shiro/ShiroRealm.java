package com.zking.ssm.shiro;

import com.zking.ssm.model.SysUser;
import com.zking.ssm.service.ISysUserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

public class ShiroRealm extends AuthorizingRealm{
   @Autowired
   private ISysUserService sysUserService;
    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //获取token中的用户username
        String username=principalCollection.getPrimaryPrincipal().toString();
        //根据用户名找到相对应的角色
        Set<String> roles = sysUserService.findRoles(username);
        Set<String> permissions = sysUserService.findPermissions(username);
//        将角色和权限设置到SimpleAuthorizationInfo
        SimpleAuthorizationInfo authz=new SimpleAuthorizationInfo();
        authz.setRoles(roles);
        authz.setStringPermissions(permissions);
        return authz;
    }
    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String username=token.getPrincipal().toString();
//        String password=token.getCredentials().toString();


        //根据用户名获取对应的数据信息
        SysUser sysUser = sysUserService.userLogin(username);
        if(null==sysUser){
            throw new UnknownAccountException();
            //密码次数校验
        }
        SimpleAuthenticationInfo simpleAuthenticationInfo=new SimpleAuthenticationInfo(
                sysUser.getUsername(),
                sysUser.getPassword(),
                //盐
                ByteSource.Util.bytes(sysUser.getSalt()),
                this.getName()
        );
        return simpleAuthenticationInfo;
    }
}
