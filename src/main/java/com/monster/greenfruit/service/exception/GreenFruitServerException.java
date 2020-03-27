package com.monster.greenfruit.service.exception;


/**
 * Developed by Mingkey Su
 * 2020/02/25
 */
public class GreenFruitServerException extends Exception {


    private String msg;

    public GreenFruitServerException(String msg) {
        super(msg);
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "GreenFruitServerException{" +
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
