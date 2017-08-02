/***
 * @author ngounphanny
 * 
 */
package com.belms.dream.api.service;

public interface ServiceFactory {
	String getId();
	Service<?> getService();
	
}
