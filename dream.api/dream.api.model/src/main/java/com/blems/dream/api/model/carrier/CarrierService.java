/***
 * @author ngounphanny
 * 
 */
package com.blems.dream.api.model.carrier;

import com.blems.dream.api.model.BasedModel;

public class CarrierService extends BasedModel {
	
	private static final long serialVersionUID = 1L;
	private String name;
	private String code;
	private Carrier carrier;
	private boolean activeFlag;
	private boolean readOnly;
	
	
	public CarrierService() {
	}
	
	public CarrierService(int id, String name) {
		setId(id);
		setName(name);
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
	public Carrier getCarrier() {
		return carrier;
	}
	public void setCarrier(Carrier carrier) {
		this.carrier = carrier;
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
