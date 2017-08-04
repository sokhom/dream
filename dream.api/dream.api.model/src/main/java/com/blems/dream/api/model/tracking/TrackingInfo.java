package com.blems.dream.api.model.tracking;



import java.util.Date;

import com.blems.dream.api.model.BasedModel2;
import com.blems.dream.api.model.tag.Tag;

public class TrackingInfo extends BasedModel2 {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String info;
	private Date infoDate;
	private double infoDouble;
	private int infoInteger;
	private float qty;
	private PartTracking partTracking;
	private Tag tag;

}
