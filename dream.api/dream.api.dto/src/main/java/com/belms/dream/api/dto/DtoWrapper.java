/***
 * @author ngounphanny
 * 
 */
package com.belms.dream.api.dto;

public class DtoWrapper<T> {

	
	public enum TYPE {NEW, UPDATE, REMOVE, INFO};
	
	private T model;
	private TYPE type;
	
	public DtoWrapper(T model, TYPE type) {
		this.model = model;
		this.type = type;
	}

	public T getModel() {
		return model;
	}

	public TYPE getType() {
		return type;
	}


}
