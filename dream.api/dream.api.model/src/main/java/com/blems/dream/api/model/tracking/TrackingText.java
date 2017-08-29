package com.blems.dream.api.model.tracking;



import java.util.Date;

import com.blems.dream.api.model.BasedModel2;
import com.blems.dream.api.model.tag.Tag;

public class TrackingText extends BasedModel2 {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String info;
	private PartTracking partTracking;
	private Tag tag;
	
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
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

	
}
