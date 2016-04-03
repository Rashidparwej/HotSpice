package com.fny.reports.commons.entity;

public class OrderDetailsDO {
	
	public Integer orderId;
	public Integer itemId;
	public Integer quantity;
	public String status;
	public Integer userId;

	
	public OrderDetailsDO(Integer itemId, Integer quantity, Integer userId) {
		super();
		this.itemId = itemId;
		this.quantity = quantity;
		this.userId = userId;
	}
	
	public OrderDetailsDO(Integer orderId, String status) {
		super();
		this.orderId = orderId;
		this.status = status;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	public Integer getItemId() {
		return itemId;
	}
	public void setItemId(Integer itemId) {
		this.itemId = itemId;
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
	

}
