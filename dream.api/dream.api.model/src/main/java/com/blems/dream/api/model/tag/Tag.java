package com.blems.dream.api.model.tag;

import java.util.Date;

import com.blems.dream.api.model.DefaultModel;
import com.blems.dream.api.model.location.Location;
import com.blems.dream.api.model.part.Part;

public class Tag extends DefaultModel {
	
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

}
