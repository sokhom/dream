/***
 * @author ngounphanny
 * 
 */
package com.blems.dream.api.model.address;

import com.blems.dream.api.model.BasedModel;

public class Country extends BasedModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private String abbriviation;
	
	public Country() {
	}
	
	public Country(int id, String name) {
		 setId(id);
		 setName(name);
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAbbriviation() {
		return abbriviation;
	}
	public void setAbbriviation(String abbriviation) {
		this.abbriviation = abbriviation;
	}

	@Override
	public String toString() {
		return getName();
	}
	
	
	
	
}
