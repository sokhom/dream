/***
 * @author ngounphanny
 * 
 */
package com.blems.dream.api.model.payment;

import com.blems.dream.api.model.BasedModel;

public class PaymentMethod extends BasedModel {
	private static final long serialVersionUID = 1L;
	private String name;
	private PaymentType type;
	private boolean activeFlag;
	private boolean readOnly;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public PaymentType getType() {
		return type;
	}
	public void setType(PaymentType type) {
		this.type = type;
	}
	public boolean isActiveFlag() {
		return activeFlag;
	}
	public void setActiveFlag(boolean activeFlag) {
		this.activeFlag = activeFlag;
	}
	public boolean isReadOnly() {
		return readOnly;
	}
	public void setReadOnly(boolean readOnly) {
		this.readOnly = readOnly;
	}
	
	
	
}
