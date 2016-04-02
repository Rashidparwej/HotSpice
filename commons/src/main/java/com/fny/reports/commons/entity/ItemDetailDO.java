package com.fny.reports.commons.entity;

public class ItemDetailDO {

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer itemId;
	public String name;
	public Integer userId;
	public Integer categoryId;
	public Integer getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}
	public Integer getItemId() {
		return itemId;
	}
	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public ItemDetailDO(Integer itemId, String name) {
		super();
		this.itemId = itemId;
		this.name = name;
	}
	public ItemDetailDO() {
		// TODO Auto-generated constructor stub
	}
	
	
}
