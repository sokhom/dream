/***
 * @author ngounphanny
 * 
 */
package com.blems.dream.api.model.address;

import com.blems.dream.api.model.BasedModel;

public class AddressType extends BasedModel {

	private static final long serialVersionUID = 1L;
	
	public AddressType(int id, String name) {
		setId(id);
		setName(name);
	}
	
	private String name;

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
