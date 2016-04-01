package com.fny.reports.commons.entity;

public class OrderSummaryDO {
	public Integer orderId;
	public String customerName;
	public String email;
	public String dishName;
	public Integer cost;
	public Integer quantity;
	public String status;
	public String date;
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDishName() {
		return dishName;
	}
	public void setDishName(String dishName) {
		this.dishName = dishName;
	}
	public Integer getCost() {
		return cost;
	}
	public void setCost(Integer cost) {
		this.cost = cost;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
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
	public OrderSummaryDO(Integer orderId, String customerName, String email, String dishName, Integer cost,
			Integer quantity, String status, String date) {
		super();
		this.orderId = orderId;
		this.customerName = customerName;
		this.email = email;
		this.dishName = dishName;
		this.cost = cost;
		this.quantity = quantity;
		this.status = status;
		this.date = date;
	}
	
	

}
