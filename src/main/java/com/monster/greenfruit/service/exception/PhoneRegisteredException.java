package com.monster.greenfruit.service.exception;

public class PhoneRegisteredException extends Exception {

	private String msg;

	public PhoneRegisteredException() { }

	public PhoneRegisteredException(String msg) {
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
