package com.monster.greenfruit.config.shiro;


import com.monster.greenfruit.config.shiro.realm.GreenFruitAdminRealm;
import com.monster.greenfruit.config.shiro.anno.BeanAdminRealm;
import com.monster.greenfruit.config.shiro.anno.BeanCredentialsMatcher;
import com.monster.greenfruit.config.shiro.anno.BeanSecurityManager;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.LinkedHashMap;
import java.util.Map;

@PropertySource(value = {"classpath:shiroConfig.properties"})
@Configuration
public class GreenFruitShiroConfig {


    @Value("${anno}")
    private String anon;

//    @Value("${admin_add}")
//    private String admin_add;
//
//    @Value("${admin_del}")
//    private String admin_del;

    @Value("${admin_manage}")
    private String adminManage;


    @Bean
    @BeanCredentialsMatcher
    public HashedCredentialsMatcher hashedCredentialsMatcher() {
        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();

        hashedCredentialsMatcher.setHashAlgorithmName("MD5");
        hashedCredentialsMatcher.setHashIterations(1024);
        hashedCredentialsMatcher.setStoredCredentialsHexEncoded(true);//使用16进制编码，否则使用Base64编码会报错
        return hashedCredentialsMatcher;

    }


    @Bean
    @BeanAdminRealm
    public GreenFruitAdminRealm greenFruitAdminRealm(@BeanCredentialsMatcher HashedCredentialsMatcher credentialsMatcher) {

        GreenFruitAdminRealm adminRealm = new GreenFruitAdminRealm();

        adminRealm.setAuthorizationCachingEnabled(false);

        adminRealm.setCredentialsMatcher(credentialsMatcher);

        return adminRealm;

    }

    private Map<String, String> addAuthenticationUrl(Map<String, String> filterMap){

        /*
            anon:无需认证
            authc:需要认证
            user:必须拥有记住我
            perms:拥有权限才能访问
            roles:拥有角色权限才能访问
         */
        /*
            绿小萝系统中:
               1、用户管理员 usrManage
               2、订单管理员 orderManage
               3、活动管理员 activitySet
               4、超级管理员 adminManage
         */

        // 配置无需认证的url
        for(String anonUrl:anon.split(","))
            filterMap.put(anonUrl,"anon");


        for(String url:adminManage.split(",")){
            filterMap.put(url,"roles[admin_manage]");
        }

        // 除了登陆、退出、静态资源外，全都要认证
        filterMap.put("/**", "authc");

        return filterMap;

    }


    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(
            @BeanSecurityManager DefaultWebSecurityManager securityManager) {
        ShiroFilterFactoryBean factoryBean = new ShiroFilterFactoryBean();


        //设置安全管理器
        factoryBean.setSecurityManager(securityManager);

        Map<String, String> filterMap = addAuthenticationUrl(new LinkedHashMap<>());

        factoryBean.setFilterChainDefinitionMap(filterMap);

        factoryBean.setLoginUrl("/greenfruit/admin/admin/page/login");
        factoryBean.setUnauthorizedUrl("/greenfruit/admin/power/unauthorized.action");

        return factoryBean;
    }


    @Bean
    @BeanSecurityManager
    public DefaultWebSecurityManager getDefaultWebSecurityManager(
            @BeanAdminRealm GreenFruitAdminRealm greenFruitAdminRealm) {

        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();

        securityManager.setRealm(greenFruitAdminRealm);

        return securityManager;
    }


    @Bean
    public SessionManager sessionManager(){
        DefaultWebSessionManager sessionManager = new DefaultWebSessionManager();
        //设置session过期时间
        sessionManager.setGlobalSessionTimeout(30*60*1000);
        sessionManager.setSessionValidationSchedulerEnabled(true);
        // 去掉shiro登录时url里的JSESSIONID
        sessionManager.setSessionIdUrlRewritingEnabled(false);
        return sessionManager;
    }




}
