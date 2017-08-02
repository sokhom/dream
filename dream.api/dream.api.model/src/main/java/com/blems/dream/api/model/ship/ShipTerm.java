/***
 * @author ngounphanny
 * 
 */
package com.blems.dream.api.model.ship;

import com.blems.dream.api.model.BasedModel;

public class ShipTerm extends BasedModel{

	private static final long serialVersionUID = 1L;
	private String name;
	private boolean activeFlag;
	private boolean readOnly;
	
	public ShipTerm() {}
	
	public ShipTerm(int id, String name) {
		setId(id);
		setName(name);
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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

	@Override
	public String toString() {
		return getName();
	}
	
	
	

}
