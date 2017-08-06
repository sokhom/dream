package com.blems.dream.api.model.coa;

import com.blems.dream.api.model.BasedModel2;

public class CoAType extends BasedModel2 {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public CoAType(String name) {
		this(0,name);
	}
	
	public CoAType(int id, String name) {
		setId(id);
		setName(name);
	}
	

}
