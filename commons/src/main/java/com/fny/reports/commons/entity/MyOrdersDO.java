package com.fny.reports.commons.entity;

public class MyOrdersDO {

	public Integer orderId;
	public String status;
	public String date;
	public MyOrdersDO(Integer orderId, String status, String date) {
		super();
		this.orderId = orderId;
		this.status = status;
		this.date = date;
	}
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
}
