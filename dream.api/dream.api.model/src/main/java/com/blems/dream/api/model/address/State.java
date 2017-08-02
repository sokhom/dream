/***
 * @author ngounphanny
 * 
 */
package com.blems.dream.api.model.address;

import com.blems.dream.api.model.BasedModel;

public class State extends BasedModel {

	private static final long serialVersionUID = 1L;
	
	private Country country;
	private String name;
	private String code;
	
	public State(int id, String name) {
		setId(id);
		setName(name);
	}
	
	public Country getCountry() {
		return country;
	}
	public void setCountry(Country country) {
		this.country = country;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}

	@Override
	public String toString() {
		return getName();
	}
	
	
	
	
}
