package com.blems.dream.api.model.part;

import com.blems.dream.api.model.BasedModel;
import com.blems.dream.api.model.tracking.PartTracking;

public class PartToTracking extends BasedModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String nextValue;
	private Part part;
	private PartTracking partTracking;
	private boolean primaryFlag;
	private boolean selectedFlag;
	
	public PartToTracking(){
		
	} 
	public PartToTracking(String nextValue,PartTracking partTracking) {
		setNextValue(nextValue);
		setPartTracking(partTracking);
		
	}
	public String getNextValue() {
		return nextValue;
	}
	public void setNextValue(String nextValue) {
		this.nextValue = nextValue;
	}
	public Part getPart() {
		return part;
	}
	public void setPart(Part part) {
		this.part = part;
	}
	public PartTracking getPartTracking() {
		return partTracking;
	}
	public void setPartTracking(PartTracking partTracking) {
		this.partTracking = partTracking;
	}
	public boolean isPrimaryFlag() {
		return primaryFlag;
	}
	public void setPrimaryFlag(boolean primaryFlag) {
		this.primaryFlag = primaryFlag;
	}
	public boolean isSelectedFlag() {
		return selectedFlag;
	}
	public void setSelectedFlag(boolean selectedFlag) {
		this.selectedFlag = selectedFlag;
	}
	
	
	

	
}
