package com.monster.greenfruit.pojo.dto;

import java.io.Serializable;

public class MessageBean implements Serializable {

    private String msg;
    private Integer status;
    private Object data;

    public MessageBean() {
    }

    public MessageBean(Integer status, String msg, Object data) {
        this.msg = msg;
        this.status = status;
        this.data = data;
    }

    @Override
    public String toString() {
        return "MessageBean{" +
                "msg='" + msg + '\'' +
                ", status=" + status +
                ", data=" + data +
                '}';
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
