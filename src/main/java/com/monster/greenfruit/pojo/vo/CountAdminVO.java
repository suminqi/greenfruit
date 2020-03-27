package com.monster.greenfruit.pojo.vo;

import java.io.Serializable;

public class CountAdminVO implements Serializable {
	private Integer adminManage;
	private Integer activitySet;
	private Integer orderManage;
	private Integer usrManage;

	@Override
	public String toString() {
		return "CountAdminDTO{" +
				"adminManage=" + adminManage +
				", activitySet=" + activitySet +
				", orderManage=" + orderManage +
				", usrManage=" + usrManage +
				'}';
	}

	public Integer getAdminManage() {
		return adminManage;
	}

	public void setAdminManage(Integer adminManage) {
		this.adminManage = adminManage;
	}

	public Integer getActivitySet() {
		return activitySet;
	}

	public void setActivitySet(Integer activitySet) {
		this.activitySet = activitySet;
	}

	public Integer getOrderManage() {
		return orderManage;
	}

	public void setOrderManage(Integer orderManage) {
		this.orderManage = orderManage;
	}

	public Integer getUsrManage() {
		return usrManage;
	}

	public void setUsrManage(Integer usrManage) {
		this.usrManage = usrManage;
	}
}
