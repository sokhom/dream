/***
 * @author ngounphanny
 * 
 */
package com.blems.dream.api.model;

import java.io.Serializable;

public abstract class BasedModel implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private int id;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}	
}
