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

}
