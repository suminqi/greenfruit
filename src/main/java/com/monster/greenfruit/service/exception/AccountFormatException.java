package com.monster.greenfruit.service.exception;

public class AccountFormatException extends Exception {

    private String message;

    public AccountFormatException(String message) {
        this.message = message;
    }

    public AccountFormatException() {
    }

    @Override
    public String toString() {
        return "AccountFormatException{" +
                "message='" + message + '\'' +
                '}';
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
