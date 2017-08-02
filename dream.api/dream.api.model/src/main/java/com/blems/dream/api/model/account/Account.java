/***
 * @author ngounphanny
 * 
 */
package com.blems.dream.api.model.account;

import com.blems.dream.api.model.BasedModel;

public class Account extends BasedModel {


	private static final long serialVersionUID = 1L;
	private AccountType type;
	public AccountType getType() {
		return type;
	}
	public void setType(AccountType type) {
		this.type = type;
	}


	
	
	
}
