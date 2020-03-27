package com.monster.greenfruit.service.exception;


/**
 * session过期异常
 */
public class SessionExpirationException extends Exception {

    private String msg;

    public SessionExpirationException(String msg) {
        super(msg);
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
