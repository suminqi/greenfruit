package com.monster.greenfruit.controller;


import com.monster.greenfruit.service.exception.*;
import com.monster.greenfruit.pojo.dto.MessageBean;
import com.monster.greenfruit.utils.utilsclass.ToolMessage;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Arrays;

/**
 * developed by Mingkey Su
 * 2020/03/04
 */


@ControllerAdvice
public class GreenFruitControllerAdvice {


    /**
     * 前端异常处理
     *
     * @param frontException
     * @return MessageBean
     */
    @ExceptionHandler(FrontException.class)
    public @ResponseBody
    MessageBean frontException(FrontException frontException) {
        return ToolMessage.failureFront(frontException.getMsg());
    }


    /**
     * 服务器异常处理
     *
     * @param serverException
     * @return MessageBean
     */
    @ExceptionHandler(GreenFruitServerException.class)
    public @ResponseBody
    MessageBean serverException(GreenFruitServerException serverException) {
        return ToolMessage.failureSys(serverException.getMsg());
    }


    /**
     * 前端参数空异常处理
     *
     * @param nullException
     * @return MessageBean
     */
    @ExceptionHandler(GreenFruitNullException.class)
    public @ResponseBody
    MessageBean nullException(GreenFruitNullException nullException) {
        return ToolMessage.failureFront(nullException.getMsg());
    }


    /**
     * 权限异常处理
     *
     * @param authorityException
     * @return MessageBean
     */
    @ExceptionHandler(InsufficientAuthorityException.class)
    public @ResponseBody
    MessageBean authorityException(InsufficientAuthorityException authorityException) {
        return ToolMessage.failureAuthority(authorityException.getMsg());
    }

    /**
     * 帐号不存在异常处理
     *
     * @param accountException
     * @return MessageBean
     */
    @ExceptionHandler({UnknownAccountException.class})
    public @ResponseBody
    MessageBean unknownAccountException(UnknownAccountException accountException) {
        return ToolMessage.failureFront(accountException.getMessage());
    }


    /**
     * 账号或密码错误异常
     * @param credentialsException
     * @return
     */
    @ExceptionHandler(IncorrectCredentialsException.class)
    public @ResponseBody
    MessageBean incorrectCredentialsException(IncorrectCredentialsException credentialsException) {
        return ToolMessage.failureFront("账号或密码错误");
    }


    /**
     * 手机号已被使用
     * @param registeredException
     * @return
     */
    @ExceptionHandler(PhoneRegisteredException.class)
    public @ResponseBody
    MessageBean sQLIntegrityConstraintViolationException(PhoneRegisteredException registeredException) {
        return ToolMessage.failure(registeredException.getMsg());
    }


    /**
     * 账号格式异常
     * @param formatException
     * @return
     */
    @ExceptionHandler(AccountFormatException.class)
    public @ResponseBody
    MessageBean numberFormatException(AccountFormatException formatException) {
        return ToolMessage.failure(formatException.getMessage());
    }


    @ExceptionHandler({UnauthorizedException.class, AuthorizationException.class})
    public @ResponseBody
    MessageBean unauthorizedException(UnauthorizedException exception){
        return ToolMessage.failureAuthority("权限不足");
    }

}
