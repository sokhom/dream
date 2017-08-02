/***
 * @author ngounphanny
 * 
 */
package com.belms.dream.api.service;

import java.io.Serializable;

public class DefaultServiceParams<T extends Serializable> implements ServiceParams<T> {

	private String id;
	private String action;
	private T params;
	
	
	public DefaultServiceParams(final String action, final T params) {

		this.params = params;
		this.action = action;
	}
	
	@Override
	public T getParams() {
		return params;
	}

	@Override
	public String getAction() {
		return action;
	}

	@Override
	public String getId() {
		return id;
	}
}
