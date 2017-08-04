package com.blems.dream.api.model.part;

import java.util.List;

import com.blems.dream.api.model.DefaultModel;
import com.blems.dream.api.model.bom.Bom;
import com.blems.dream.api.model.coa.ChartAccount;
import com.blems.dream.api.model.product.Product;
import com.blems.dream.api.model.tax.TaxRate;
import com.blems.dream.api.model.ui.FilterItemList;
import com.blems.dream.api.model.uom.Uom;

public class Part extends DefaultModel implements FilterItemList{
	private static final long serialVersionUID = 1L;

	private String num;
	private String description;
	private String details;
	private String upc;
	private String abcCode;
	private String url;
	private PartType partType;
	
	private ChartAccount cogsAccount;
	private ChartAccount inventoryAccount;
	private ChartAccount crapAccount;
	private ChartAccount adjustmentAccount;
	private ChartAccount varianceAccount;
	
	private Product defaultProduct;
	private List<PartToTracking> partToTrackings;
	
	private Bom defaultBom;
	private Uom uom;
	private TaxRate tax;
	
	private String alertNote;
	
	private float len;
	private float width;
	private float height;
	private Uom sizeUom;
	
	private float weight;
	private Uom weightUom;
		
	private boolean alwaysManufacture;
	private boolean pickedInUomPart;
	
	
	private float stdCost;
	
	private boolean trackingFlag;
	private boolean serializedFlag;
	
	
	@Override
	public String getDescription() {
		
		return null;
	}
	
	
	
}
