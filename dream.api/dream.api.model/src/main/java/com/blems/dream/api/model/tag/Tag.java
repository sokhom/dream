package com.blems.dream.api.model.tag;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.blems.dream.api.model.DefaultModel;
import com.blems.dream.api.model.location.Location;
import com.blems.dream.api.model.part.Part;
import com.blems.dream.api.model.tracking.PartTracking;
import com.blems.dream.api.model.tracking.Serial;
import com.blems.dream.api.model.tracking.TrackingDate;
import com.blems.dream.api.model.tracking.TrackingDecimal;
import com.blems.dream.api.model.tracking.TrackingInteger;
import com.blems.dream.api.model.tracking.TrackingText;

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
	
	//Tracking
	private Serial serial;
	private Map<PartTracking, TrackingText> trackingTextMapping = new HashMap<>();;
	private TrackingDate trackingDate;
	private TrackingDecimal trackingDecimal;
	private TrackingInteger trackingInteger;
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
	// Tracking Tag: new inventory 
	public Serial getSerial() {
		if(serial==null){
			serial = new Serial();
		}
		return serial;
	}
	public void setSerial(Serial serial) {
		this.serial = serial;
	}
	
	public TrackingText getTrackingTextMapping(PartTracking partTracking) {
		TrackingText trackingText = trackingTextMapping.get(partTracking);		
		if(trackingText==null){
			trackingText = new TrackingText();
			trackingTextMapping.put(partTracking, trackingText);
		}
		return trackingText;
	}
	
	public TrackingDate getTrackingDate() {
		if(trackingDate==null){
			trackingDate = new TrackingDate();
		}
		return trackingDate;
	}
	public void setTrackingDate(TrackingDate trackingDate) {
		this.trackingDate = trackingDate;
	}
	public TrackingDecimal getTrackingDecimal() {
		if(trackingDecimal==null){
			trackingDecimal = new TrackingDecimal();
		}
		return trackingDecimal;
	}
	public void setTrackingDecimal(TrackingDecimal trackingDecimal) {
		this.trackingDecimal = trackingDecimal;
	}
	public TrackingInteger getTrackingInteger() {
		if(trackingInteger==null){
			trackingInteger = new TrackingInteger();
		}
		return trackingInteger;
	}
	public void setTrackingInteger(TrackingInteger trackingInteger) {
		this.trackingInteger = trackingInteger;
	}
	
	

	
}
