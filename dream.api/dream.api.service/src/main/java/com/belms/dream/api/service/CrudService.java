/***
 * @author ngounphanny
 * 
 */
package com.belms.dream.api.service;

import java.util.List;

public interface CrudService<T> extends Service<T> {
	
	T add(T t);

	void remove(T t);

	void edit(T t);

	T getById(int id);

	List<T> getAll();
	
	
}
