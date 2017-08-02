/***
 * @author ngounphanny
 * 
 */
package com.blems.dream.api.model.carrier;

import com.blems.dream.api.model.BasedModel;

public class Carrier extends BasedModel {
	
	private static final long serialVersionUID = 1L;
	private boolean activeFlag;
	private String name;
	private String description;
	private boolean readOnly;
	
	public Carrier() {
	}
	
	public Carrier(int id, String name) {
		setId(id);
		setName(name);
	}
	
	public boolean isActiveFlag() {
		return activeFlag;
	}
	public void setActiveFlag(boolean activeFlag) {
		this.activeFlag = activeFlag;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
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
