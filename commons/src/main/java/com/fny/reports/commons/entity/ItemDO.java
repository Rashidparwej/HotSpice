package com.fny.reports.commons.entity;

public class ItemDO {

	public Integer itemId;
	public Integer categoryId;
	public String name;
	public ItemDO(int itemId, String name) {
		this.itemId=itemId;
		this.name=name;
	
	}
	public ItemDO() {
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer cost;
	public Integer getItemId() {
		return itemId;
	}
	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}
	public Integer getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}
	
	public Integer getCost() {
		return cost;
	}
	public void setCost(Integer cost) {
		this.cost = cost;
	}
	
}
