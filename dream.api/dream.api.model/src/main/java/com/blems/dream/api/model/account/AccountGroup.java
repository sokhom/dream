/***
 * @author ngounphanny
 * 
 */
package com.blems.dream.api.model.account;

import com.blems.dream.api.model.BasedModel;

public class AccountGroup extends BasedModel {

	private static final long serialVersionUID = 1L;
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
