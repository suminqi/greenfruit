package com.monster.greenfruit.service.exception;


/**
 * Developed by Mingkey Su
 * 2020/02/25
 */
public class FrontException extends Exception {

    private String msg;


    public FrontException(String msg) {
        super(msg);
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "FrontException{" +
                "msg='" + msg + '\'' +
                '}';
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
