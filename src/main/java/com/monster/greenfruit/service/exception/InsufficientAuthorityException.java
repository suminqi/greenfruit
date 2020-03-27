package com.monster.greenfruit.service.exception;


/**
 * Developed by Mingkey Su
 * 2020/02/25
 */
public class InsufficientAuthorityException extends Exception {

    private String msg;

    public InsufficientAuthorityException(String msg) {
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
