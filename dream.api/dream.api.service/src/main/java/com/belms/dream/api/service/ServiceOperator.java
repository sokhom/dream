/***
 * @author ngounphanny
 * 
 */
package com.belms.dream.api.service;

import java.io.Serializable;
import java.util.List;

public interface ServiceOperator<T extends Serializable> {
	T add(T t);
	void remove(T t);
	T edit(T t);
	List<T> getAll();
	T getById(int Id);
}
