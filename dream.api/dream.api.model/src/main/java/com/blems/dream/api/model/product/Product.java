package com.blems.dream.api.model.product;

import com.blems.dream.api.model.DefaultModel;

public class Product extends DefaultModel{

	private static final long serialVersionUID = 1L;

	private String description;
	private String upc;
	private float price;
	
	
	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getUpc() {
		return upc;
	}


	public void setUpc(String upc) {
		this.upc = upc;
	}


	public float getPrice() {
		return price;
	}


	public void setPrice(float price) {
		this.price = price;
	}


	@Override
	public String toString() {
		
		return getName();
	}
	
	

}
