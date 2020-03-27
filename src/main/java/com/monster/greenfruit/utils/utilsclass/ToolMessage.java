package com.monster.greenfruit.utils.utilsclass;

import com.monster.greenfruit.utils.constant.RequestConsts;
import com.monster.greenfruit.pojo.dto.MessageBean;

public class ToolMessage {


    /**
     * 通用
     *
     * @param status 状态
     * @param msg    提示信息   下同
     * @param data   数据      下同
     * @return MessageBean
     */
    public static MessageBean currency(Integer status, String msg, Object data) {
        return new MessageBean(status, msg, data);
    }


    /**
     * 请求成功
     *
     * @param msg
     * @param data
     * @return MessageBean
     */
    public static MessageBean success(String msg, Object data) {
        return currency(RequestConsts.REQUEST_SUCCESS, msg, data);
    }

    public static MessageBean success(String msg) {
        return success(msg, null);
    }

    public static MessageBean success(Object data) {
        return success(RequestConsts.MSG_SUCCESS, data);
    }

    public static MessageBean success() {
        return success(RequestConsts.MSG_SUCCESS);
    }


    /**
     * 前端错误
     *
     * @param msg
     * @param data
     * @return MessageBean
     */
    public static MessageBean failureFront(String msg, Object data) {
        return currency(RequestConsts.REQUEST_FAILURE_FRONT, msg, data);
    }

    public static MessageBean failureFront(String msg) {
        return failureFront(msg, null);
    }

    public static MessageBean failureFront(Object data) {
        return failureFront(RequestConsts.MSG_FAILURE_FRONT, data);
    }

    public static MessageBean failureFront() {
        return failureFront(RequestConsts.MSG_FAILURE_FRONT);
    }


    /**
     * 正常错误
     *
     * @param msg
     * @param data
     * @return MessageBean
     */
    public static MessageBean failure(String msg, Object data) {
        return currency(RequestConsts.REQUEST_FAILURE_NORMAL, msg, data);
    }

    public static MessageBean failure(String msg) {
        return failure(msg, null);
    }

    public static MessageBean failure(Object data) {
        return failure(RequestConsts.MSG_FAILURE_NORMAL, data);
    }

    public static MessageBean failure() {
        return failure(null);
    }


    /**
     * 系统错误
     *
     * @param msg
     * @param data
     * @return MessageBean
     */
    public static MessageBean failureSys(String msg, Object data) {
        return currency(RequestConsts.REQUEST_FAILURE_SYS, msg, data);
    }

    public static MessageBean failureSys(String msg) {
        return failureSys(msg, null);
    }

    public static MessageBean failureSys(Object data) {
        return failureSys(RequestConsts.MSG_FAILURE_SYS, data);
    }

    public static MessageBean failureSys() {
        return failureSys(null);
    }


    /**
     * 后端数据更新错误
     *
     * @param msg
     * @param data
     * @return MessageBean
     */
    public static MessageBean failureDataUpdate(String msg, Object data) {
        return currency(RequestConsts.REQUEST_DATA_UPDATE_FAILURE, msg, data);
    }

    public static MessageBean failureDataUpdate(String msg) {
        return failureDataUpdate(msg, null);
    }

    public static MessageBean failureDataupdate(Object data) {
        return failureDataUpdate(RequestConsts.MSG_DATA_UPDATE_FAILURE, data);
    }

    public static MessageBean failureDataUpdate() {
        return failureDataUpdate(null);
    }


    /**
     * 验证失败，返回400
     *
     * @param data
     * @return MessageBean
     */
    public static MessageBean failureValid(Object data) {
        return currency(RequestConsts.VALID_FAILURE, RequestConsts.MSG_VALID_FAILURE, data);
    }

    public static MessageBean failureValid() {
        return failureValid(null);
    }


    /**
     * 访问权限异常  (暂定，不确定是否使用所有功能)
     *
     * @param msg
     * @param data
     * @return MessageBean
     */
    public static MessageBean failureAuthority(String msg, Object data) {
        return currency(RequestConsts.REQUEST_FAILURE_AUTHORITY, msg, data);
    }

    public static MessageBean failureAuthority(String msg) {
        return failureAuthority(msg, null);
    }

    public static MessageBean failureAuthority(Object data) {
        return failureAuthority(RequestConsts.MSG_FAILURE_AUTHORITY, data);
    }

    public static MessageBean failureAuthority() {
        return failureAuthority(null);
    }


}
