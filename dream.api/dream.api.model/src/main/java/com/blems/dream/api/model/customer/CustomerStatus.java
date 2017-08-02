/***
 * @author ngounphanny
 * 
 */
package com.blems.dream.api.model.customer;

import java.io.Serializable;

import com.blems.dream.api.model.BasedModel;

public class CustomerStatus extends BasedModel implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String name;
	
	
	public CustomerStatus() {
	
	}
	
	public CustomerStatus(int id, String name) {
		setId(id);
		setName(name);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return getName();
	} 

	
	
	
	
}
