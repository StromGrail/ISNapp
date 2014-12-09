package com.isn.model;

import java.io.Serializable;

public class women implements Serializable{
	private int productId = 0;
	private String name = null;
	private String description = null;
	private float price = 0;
	private String productImage = null;
	private long stock_avail= 0;
		
	
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getProductImage() {
		return productImage;
	}
	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}
	public long getStock_avail() {
		return stock_avail;
	}
	public void setStock_avail(long stock_avail) {
		this.stock_avail = stock_avail;
	}
	
}
