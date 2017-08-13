package com.blems.dream.api.model.location;

import java.util.List;

import com.blems.dream.api.model.BasedModel2;

public class LocationGroup extends BasedModel2 {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<Location> locations;

	public List<Location> getLocations() {
		return locations;
	}

	public void setLocations(List<Location> locations) {
		this.locations = locations;
	}
	
	
}
