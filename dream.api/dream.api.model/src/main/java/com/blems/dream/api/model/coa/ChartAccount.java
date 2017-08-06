package com.blems.dream.api.model.coa;

import com.blems.dream.api.model.DefaultModel;

public class ChartAccount extends DefaultModel {
	private static final long serialVersionUID = 1L;
	
	private String accountNumber;
	private CoAType type;
	
	public ChartAccount(int id,String accountName,String name,CoAType coaType){
		setId(id);
		setName(name);
		setAccountNumber(accountName);
		setType(coaType);		
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public CoAType getType() {
		return type;
	}
	public void setType(CoAType type) {
		this.type = type;
	}
	
	
	
	

}
