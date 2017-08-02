/***
 * @author ngounphanny
 * 
 */
package com.blems.dream.api.model;

import java.io.Serializable;
import java.util.Date;

public abstract class DefaultModel extends BasedModel implements Serializable, Cloneable  {
	
	private static final long serialVersionUID = 1L;
	
	private String name;
	private boolean activeFlag;
	private Date dateCreated;
	private Date dateLastModified;
	private int lastChangedUserId;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isActiveFlag() {
		return activeFlag;
	}
	public void setActiveFlag(boolean activeFlag) {
		this.activeFlag = activeFlag;
	}
	public Date getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}
	public Date getDateLastModified() {
		return dateLastModified;
	}
	public void setDateLastModified(Date dateLastModified) {
		this.dateLastModified = dateLastModified;
	}
	public int getLastChangedUserId() {
		return lastChangedUserId;
	}
	public void setLastChangedUserId(int lastChangedUserId) {
		this.lastChangedUserId = lastChangedUserId;
	}
	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	
	
	

}
