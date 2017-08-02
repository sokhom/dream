/***
 * @author ngounphanny
 * 
 */
package com.belms.dream.api.service;

import java.io.Serializable;

public interface ServiceParams<T extends Serializable> {
	String getId();
	String getAction();
	T getParams();
}	
