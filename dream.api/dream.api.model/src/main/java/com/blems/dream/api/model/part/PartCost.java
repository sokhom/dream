package com.blems.dream.api.model.part;

import java.sql.Date;

import com.blems.dream.api.model.BasedModel;

public class PartCost extends BasedModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private float avgCost;
	private Date createdDate;
	private Date lastModifiedDate;
	private Part part;
	private int qty;
	private float totalCost;
	public float getAvgCost() {
		return avgCost;
	}
	public void setAvgCost(float avgCost) {
		this.avgCost = avgCost;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public Date getLastModifiedDate() {
		return lastModifiedDate;
	}
	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}
	public Part getPart() {
		return part;
	}
	public void setPart(Part part) {
		this.part = part;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public float getTotalCost() {
		return totalCost;
	}
	public void setTotalCost(float totalCost) {
		this.totalCost = totalCost;
	}

}
