/***
 * @author ngounphanny
 * 
 */
package com.belms.dream.api.view;

import com.vaadin.ui.Component;

public interface EntryView<T> {
	boolean isValid();
	Component getView();
	void loadData(T data);
	

}
