package com.blems.dream.api.model.uom;

import com.blems.dream.api.model.DefaultModel;

public class Uom extends DefaultModel{

	private static final long serialVersionUID = 1L;
	
	public Uom(int id, String name){
		setId(id);
		setName(name);
	}

	@Override
	public String toString() {
		
		return getName();
	}
	
	
	

}
