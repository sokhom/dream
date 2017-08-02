/***
 * @author ngounphanny
 * 
 */
package com.blems.dream.api.model.contact;

import com.blems.dream.api.model.BasedModel;

public class ContactType extends BasedModel {

	private static final long serialVersionUID = 1L;
	private String name;
	
	public ContactType(int id, String name) {
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
