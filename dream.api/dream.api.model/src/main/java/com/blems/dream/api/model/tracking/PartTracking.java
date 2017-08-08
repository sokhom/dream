package com.blems.dream.api.model.tracking;

import com.blems.dream.api.model.DefaultModel;

public class PartTracking extends DefaultModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String abbr;
	private int sortable;
	private PartTrackingType type;
	private String description;
	public String getAbbr() {
		return abbr;
	}
	public void setAbbr(String abbr) {
		this.abbr = abbr;
	}
	public int getSortable() {
		return sortable;
	}
	public void setSortable(int sortable) {
		this.sortable = sortable;
	}
	public PartTrackingType getType() {
		return type;
	}
	public void setType(PartTrackingType type) {
		this.type = type;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	

}
