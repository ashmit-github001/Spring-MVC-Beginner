package com.ashmitagarwal.shopping_mvc_part1.models;

public class ShoppingListDTO {
	
	private String itemName = "Enter item name";
	
	private String itemType = "Enter item type";
	
	private String itemPrice = "Enter item price";

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemType() {
		return itemType;
	}

	public void setItemType(String itemType) {
		this.itemType = itemType;
	}

	public String getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(String itemPrice) {
		this.itemPrice = itemPrice;
	}
}
