/***
 * @author ngounphanny
 * 
 */
package com.blems.dream.api.model.account;

import com.blems.dream.api.model.BasedModel;

public class AccountGroupRelation extends BasedModel {
	

	private static final long serialVersionUID = 1L;

	private int accountId;
	
	private int groupId;

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public int getGroupId() {
		return groupId;
	}

	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}
	
	

}
