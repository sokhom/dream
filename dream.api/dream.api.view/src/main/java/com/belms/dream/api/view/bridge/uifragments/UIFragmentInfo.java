/***
 * @author ngounphanny
 * 
 */
package com.belms.dream.api.view.bridge.uifragments;

import com.vaadin.server.Resource;

public class UIFragmentInfo {
	public enum VIEW_LEVEL {
		LEVEL1, 
		LEVEL2,
		LEVEL3
	}
	
	
	private String id;
	private String accessCode;
	private String name;
	private String subModule;
	private String module;
	private String description;
	private int displaySeq=10000;
	private boolean navigate;
	private String navigateName;
	private boolean stateFull;
	private Resource icon;
	private boolean defaultView =false;
	
	private VIEW_LEVEL viewLevel;
	
	public String getAccessCode() {
		return accessCode;
	}
	public void setAccessCode(String accessCode) {
		this.accessCode = accessCode;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public int getDisplaySeq() {
		return displaySeq;
	}
	public void setDisplaySeq(int displaySeq) {
		this.displaySeq = displaySeq;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	public boolean isNavigate() {
		return navigate;
	}
	public void setNavigate(boolean navigate) {
		this.navigate = navigate;
	}
	public String getNavigateName() {
		return navigateName;
	}
	public void setNavigateName(String navigateName) {
		this.navigateName = navigateName;
	}
	public boolean isStateFull() {
		return stateFull;
	}
	public void setStateFull(boolean stateFull) {
		this.stateFull = stateFull;
	}
	public Resource getIcon() {
		return icon;
	}
	public void setIcon(Resource icon) {
		this.icon = icon;
	}
	public VIEW_LEVEL getViewLevel() {
		return viewLevel;
	}
	public void setViewLevel(VIEW_LEVEL viewLevel) {
		this.viewLevel = viewLevel;
	}
	public boolean isDefaultView() {
		return defaultView;
	}
	public void setDefaultView(boolean defaultView) {
		this.defaultView = defaultView;
	}
	
	
}
