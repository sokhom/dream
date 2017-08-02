package com.belms.dream.api.view.fragment;

import com.vaadin.icons.VaadinIcons;
import com.vaadin.server.Resource;

public class FragmentInfo {
	private String id;
	private String name;
	private String accessCode;
	private String subModule;
	private String module;
	private String description;
	private Resource icon = VaadinIcons.VIEWPORT;
	private boolean mainMenu = false;
	private boolean browserHistory = false;
	
	private int menuOrder ;
	
	public FragmentInfo() {}
	
	
	public FragmentInfo(String id, String name, String accessCode, String subModule, String module) {
		setId(id);
		setName(name);
		setAccessCode(accessCode);
		setSubModule(subModule);
		setModule(module);
	}
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAccessCode() {
		return accessCode;
	}
	public void setAccessCode(String accessCode) {
		this.accessCode = accessCode;
	}
	public String getSubModule() {
		return subModule;
	}
	public void setSubModule(String subModule) {
		this.subModule = subModule;
	}
	public String getModule() {
		return module;
	}
	public void setModule(String module) {
		this.module = module;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Resource getIcon() {
		return icon;
	}
	public void setIcon(Resource icon) {
		this.icon = icon;
	}

	public boolean isMainMenu() {
		return mainMenu;
	}

	public void setMainMenu(boolean mainMenu) {
		this.mainMenu = mainMenu;
	}


	public boolean isBrowserHistory() {
		return browserHistory;
	}


	public void setBrowserHistory(boolean browserHistory) {
		this.browserHistory = browserHistory;
	}


	public int getMenuOrder() {
		return menuOrder;
	}


	public void setMenuOrder(int menuOrder) {
		this.menuOrder = menuOrder;
	}
	
}
