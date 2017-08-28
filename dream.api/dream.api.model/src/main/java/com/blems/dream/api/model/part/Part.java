package com.blems.dream.api.model.part;

import java.util.ArrayList;
import java.util.List;

import com.blems.dream.api.model.DefaultModel;
import com.blems.dream.api.model.bom.Bom;
import com.blems.dream.api.model.coa.ChartAccount;
import com.blems.dream.api.model.product.Product;
import com.blems.dream.api.model.tag.Tag;
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
	private PartCost partCost;
	
	private ChartAccount cogsAccount;
	private ChartAccount inventoryAccount;
	private ChartAccount crapAccount;
	private ChartAccount adjustmentAccount;
	private ChartAccount varianceAccount;
	
	private Product defaultProduct;
	private List<PartToTracking> partToTrackings;
	private List<Tag> tags;
	
	private List<Product> products;
	
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
	



	public String getDescription() {
		return description;
	}


	public String getNum() {
		return num;
	}


	public void setNum(String num) {
		this.num = num;
	}


	public String getDetails() {
		return details;
	}


	public void setDetails(String details) {
		this.details = details;
	}


	public String getUpc() {
		return upc;
	}


	public void setUpc(String upc) {
		this.upc = upc;
	}


	public String getAbcCode() {
		return abcCode;
	}


	public void setAbcCode(String abcCode) {
		this.abcCode = abcCode;
	}


	public String getUrl() {
		return url;
	}


	public void setUrl(String url) {
		this.url = url;
	}


	public PartType getPartType() {
		return partType;
	}


	public void setPartType(PartType partType) {
		this.partType = partType;
	}


	public ChartAccount getCogsAccount() {
		return cogsAccount;
	}


	public void setCogsAccount(ChartAccount cogsAccount) {
		this.cogsAccount = cogsAccount;
	}


	public ChartAccount getInventoryAccount() {
		return inventoryAccount;
	}


	public void setInventoryAccount(ChartAccount inventoryAccount) {
		this.inventoryAccount = inventoryAccount;
	}


	public ChartAccount getCrapAccount() {
		return crapAccount;
	}


	public void setCrapAccount(ChartAccount crapAccount) {
		this.crapAccount = crapAccount;
	}


	public ChartAccount getAdjustmentAccount() {
		return adjustmentAccount;
	}


	public void setAdjustmentAccount(ChartAccount adjustmentAccount) {
		this.adjustmentAccount = adjustmentAccount;
	}


	public ChartAccount getVarianceAccount() {
		return varianceAccount;
	}


	public void setVarianceAccount(ChartAccount varianceAccount) {
		this.varianceAccount = varianceAccount;
	}


	public Product getDefaultProduct() {
		return defaultProduct;
	}


	public void setDefaultProduct(Product defaultProduct) {
		this.defaultProduct = defaultProduct;
	}


	public List<PartToTracking> getPartToTrackings() {
		if(partToTrackings==null){
			partToTrackings = new ArrayList<>();
		}
		return partToTrackings;
	}


	public void setPartToTrackings(List<PartToTracking> partToTrackings) {
		this.partToTrackings = partToTrackings;
	}

	public List<Tag> getTags() {
		if(tags==null){
			tags = new ArrayList<>();
		}
		return tags;
	}


	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}


	public Bom getDefaultBom() {
		return defaultBom;
	}


	public void setDefaultBom(Bom defaultBom) {
		this.defaultBom = defaultBom;
	}


	public Uom getUom() {
		return uom;
	}


	public void setUom(Uom uom) {
		this.uom = uom;
	}


	public TaxRate getTax() {
		return tax;
	}


	public void setTax(TaxRate tax) {
		this.tax = tax;
	}


	public String getAlertNote() {
		return alertNote;
	}


	public void setAlertNote(String alertNote) {
		this.alertNote = alertNote;
	}


	public float getLen() {
		return len;
	}


	public void setLen(float len) {
		this.len = len;
	}


	public float getWidth() {
		return width;
	}


	public void setWidth(float width) {
		this.width = width;
	}


	public float getHeight() {
		return height;
	}


	public void setHeight(float height) {
		this.height = height;
	}


	public Uom getSizeUom() {
		return sizeUom;
	}


	public void setSizeUom(Uom sizeUom) {
		this.sizeUom = sizeUom;
	}


	public float getWeight() {
		return weight;
	}


	public void setWeight(float weight) {
		this.weight = weight;
	}


	public Uom getWeightUom() {
		return weightUom;
	}


	public void setWeightUom(Uom weightUom) {
		this.weightUom = weightUom;
	}


	public boolean isAlwaysManufacture() {
		return alwaysManufacture;
	}


	public void setAlwaysManufacture(boolean alwaysManufacture) {
		this.alwaysManufacture = alwaysManufacture;
	}


	public boolean isPickedInUomPart() {
		return pickedInUomPart;
	}


	public void setPickedInUomPart(boolean pickedInUomPart) {
		this.pickedInUomPart = pickedInUomPart;
	}


	public float getStdCost() {
		return stdCost;
	}


	public void setStdCost(float stdCost) {
		this.stdCost = stdCost;
	}


	public boolean isTrackingFlag() {
		return trackingFlag;
	}


	public void setTrackingFlag(boolean trackingFlag) {
		this.trackingFlag = trackingFlag;
	}


	public boolean isSerializedFlag() {
		return serializedFlag;
	}


	public void setSerializedFlag(boolean serializedFlag) {
		this.serializedFlag = serializedFlag;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public List<Product> getProducts() {
		return products;
	}


	public void setProducts(List<Product> products) {
		this.products = products;
	}


	public PartCost getPartCost() {
		return partCost;
	}


	public void setPartCost(PartCost partCost) {
		this.partCost = partCost;
	}	
	
	
	
}
