package com.monster.greenfruit.config.shiro.realm;

import com.monster.greenfruit.pojo.domain.Admin;
import com.monster.greenfruit.pojo.domain.AdminPerms;
import com.monster.greenfruit.service.AdminPermsService;
import com.monster.greenfruit.service.AdminSevice;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class GreenFruitAdminRealm extends AuthorizingRealm {

    @Autowired
    AdminSevice adminSevice;
    @Autowired
    AdminPermsService adminPermsService;

    private Logger shiroAuthentication = LoggerFactory.getLogger("shiroAuthentication");

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        shiroAuthentication.info("————————————————————————开始授权————————————————————————");

        Admin admin = (Admin) principalCollection.getPrimaryPrincipal();

        Set<String> perms = getPermsByAdminId(admin.getAdminId());
        Set<String> roles = getRolesByAdminId(admin.getAdminId());

        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        authorizationInfo.setStringPermissions(perms);
        authorizationInfo.setRoles(roles);

        shiroAuthentication.info("————————————————————————结束授权————————————————————————");

        return authorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken)
            throws AuthenticationException {


        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;

        String adminParam = token.getUsername();

        Admin admin = adminSevice.selectByParam(adminParam);

        if (admin == null) {
            throw new UnknownAccountException("账号不存在");
        }


        //这里传入的是后端数据库的密码
        return new SimpleAuthenticationInfo(admin, admin.getPassword(),
                ByteSource.Util.bytes(admin.getAdminSalt()), "GreenFruitAdminRealm");
    }


    private Set<String> getPermsByAdminId(Long adminId){
        AdminPerms adminPerms = adminPermsService.getAdminPermsByAdminId(adminId);

        Set<String> perms = new HashSet<>();
        if(adminPerms.getPermission()==null){
            return null;
        } else if(adminPerms.getPermission().contains("&")){
            Collections.addAll(perms, adminPerms.getPermission().split("&"));
            return perms;
        }

        perms.add(adminPerms.getPermission());
        return perms;
    }

    private Set<String> getRolesByAdminId(Long adminId){
        AdminPerms adminPerms = adminPermsService.getAdminPermsByAdminId(adminId);

        Set<String> roles = new HashSet<>();

        if(adminPerms.getAdminRole().contains("&")){
            Collections.addAll(roles,adminPerms.getAdminRole().split("&"));
            return roles;
        }
        roles.add(adminPerms.getAdminRole());

        return roles;
    }


}
