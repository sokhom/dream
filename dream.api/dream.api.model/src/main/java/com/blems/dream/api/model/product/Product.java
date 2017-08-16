package com.blems.dream.api.model.product;

import com.blems.dream.api.model.DefaultModel;

public class Product extends DefaultModel{

	private static final long serialVersionUID = 1L;

	private String description;
	
	
	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	@Override
	public String toString() {
		
		return getName();
	}
	
	

}
