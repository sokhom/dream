package com.blems.dream.api.model.tag;

import java.util.Date;

import com.blems.dream.api.model.DefaultModel;
import com.blems.dream.api.model.location.Location;
import com.blems.dream.api.model.part.Part;

public class Tag extends DefaultModel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Date dateLastCycleCount;
	private Part part;
	private int num;
	private int qty;
	private int qtyCommit;
	private boolean serializedFlag;
	private String trackingEncoding;
	private boolean usedFlag;
	private TagType type;
	private Location location;
	//woItemId
	public Date getDateLastCycleCount() {
		return dateLastCycleCount;
	}
	public void setDateLastCycleCount(Date dateLastCycleCount) {
		this.dateLastCycleCount = dateLastCycleCount;
	}
	public Part getPart() {
		return part;
	}
	public void setPart(Part part) {
		this.part = part;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public int getQtyCommit() {
		return qtyCommit;
	}
	public void setQtyCommit(int qtyCommit) {
		this.qtyCommit = qtyCommit;
	}
	public boolean isSerializedFlag() {
		return serializedFlag;
	}
	public void setSerializedFlag(boolean serializedFlag) {
		this.serializedFlag = serializedFlag;
	}
	public String getTrackingEncoding() {
		return trackingEncoding;
	}
	public void setTrackingEncoding(String trackingEncoding) {
		this.trackingEncoding = trackingEncoding;
	}
	public boolean isUsedFlag() {
		return usedFlag;
	}
	public void setUsedFlag(boolean usedFlag) {
		this.usedFlag = usedFlag;
	}
	public TagType getType() {
		return type;
	}
	public void setType(TagType type) {
		this.type = type;
	}
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}

	
}
