package com.blems.dream.api.model.part;

import com.blems.dream.api.model.BasedModel2;

public class PartType extends BasedModel2{

	private static final long serialVersionUID = 1L;
	
	public PartType(int id, String name){
		setId(id);
		setName(name);
	}

	@Override
	public String toString() {
		return getName();
	}
	
	
	
}
