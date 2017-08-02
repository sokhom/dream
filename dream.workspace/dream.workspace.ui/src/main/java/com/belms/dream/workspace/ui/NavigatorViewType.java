/***
 * @author ngounphanny
 * 
 */
package com.belms.dream.workspace.ui;

import java.io.Serializable;

import com.belms.dream.api.view.bridge.uifragments.UIFragmentFactory;
import com.vaadin.server.Resource;

public class NavigatorViewType implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private final String id;
	private final String viewName;
	private UIFragmentFactory fragmentFactory;
	private final Resource icon;
	private final boolean stateful;
	private final boolean defaultView;
	
	
	public NavigatorViewType(String id,String viewName, UIFragmentFactory fragmentFactory ,Resource icon,  boolean stateful, boolean defaultview) {
		this.id = id;
		this.viewName=viewName;
		this.fragmentFactory=fragmentFactory;
		this.icon=icon;
		this.stateful=stateful;
		this.defaultView=defaultview;
	}
	
	public String getViewName() {
		return viewName;
	}
	
	public String getId() {
		return id;
	}

	
	public UIFragmentFactory getFragmentFactory() {
		return fragmentFactory;
	}

	public void setFragmentFactory(UIFragmentFactory fragmentFactory) {
		this.fragmentFactory = fragmentFactory;
	}

	public Resource getIcon() {
		return icon;
	}
	public boolean isStateful() {
		return stateful;
	}

	public boolean isDefaultView() {
		return defaultView;
	}
}
