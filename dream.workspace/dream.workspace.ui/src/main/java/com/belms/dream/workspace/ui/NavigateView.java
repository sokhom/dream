
/***
 * @author ngounphanny
 * 
 */
package com.belms.dream.workspace.ui;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Component;
import com.vaadin.ui.Panel;

public class NavigateView extends Panel implements View {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NavigateView(Component component) {
		setSizeFull();
		component.setSizeFull();
		setContent(component);
	}

	@Override
	public void enter(ViewChangeEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
