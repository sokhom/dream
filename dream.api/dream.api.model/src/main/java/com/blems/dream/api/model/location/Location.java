package com.blems.dream.api.model.location;

import com.blems.dream.api.model.DefaultModel;
import com.blems.dream.api.model.customer.Customer;

public class Location extends DefaultModel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int countedAsAvailable;
	private Customer defaultCustomer;
	//defaultVendorId
	private String description;
	private int parentId;
	private boolean pickable;
	private boolean receivable;
	private int sortOrder;
	private LocationType type;
	private LocationGroup locationGroup;
	public int getCountedAsAvailable() {
		return countedAsAvailable;
	}
	public void setCountedAsAvailable(int countedAsAvailable) {
		this.countedAsAvailable = countedAsAvailable;
	}
	public Customer getDefaultCustomer() {
		return defaultCustomer;
	}
	public void setDefaultCustomer(Customer defaultCustomer) {
		this.defaultCustomer = defaultCustomer;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getParentId() {
		return parentId;
	}
	public void setParentId(int parentId) {
		this.parentId = parentId;
	}
	public boolean isPickable() {
		return pickable;
	}
	public void setPickable(boolean pickable) {
		this.pickable = pickable;
	}
	public boolean isReceivable() {
		return receivable;
	}
	public void setReceivable(boolean receivable) {
		this.receivable = receivable;
	}
	public int getSortOrder() {
		return sortOrder;
	}
	public void setSortOrder(int sortOrder) {
		this.sortOrder = sortOrder;
	}
	public LocationType getType() {
		return type;
	}
	public void setType(LocationType type) {
		this.type = type;
	}
	public LocationGroup getLocationGroup() {
		return locationGroup;
	}
	public void setLocationGroup(LocationGroup locationGroup) {
		this.locationGroup = locationGroup;
	}
	@Override
	public String toString() {
		return getName();
	}
	
	

}
