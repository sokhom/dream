package com.blems.dream.api.model.tracking;

import com.blems.dream.api.model.BasedModel2;
import com.blems.dream.api.model.tag.Tag;

public class TrackingDecimal extends BasedModel2 {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private double info;
	private PartTracking partTracking;
	private Tag tag;
	
	public double getInfo() {
		return info;
	}
	public void setInfo(double info) {
		this.info = info;
	}
	public PartTracking getPartTracking() {
		return partTracking;
	}
	public void setPartTracking(PartTracking partTracking) {
		this.partTracking = partTracking;
	}
	public Tag getTag() {
		return tag;
	}
	public void setTag(Tag tag) {
		this.tag = tag;
	}
	@Override
	public String toString() {
		return info+"";
	}

	
	
}
