package com.belms.dream.api.dto.part;

import java.util.ArrayList;
import java.util.List;

import com.blems.dream.api.model.coa.ChartAccount;
import com.blems.dream.api.model.customer.Customer;
import com.blems.dream.api.model.location.Location;
import com.blems.dream.api.model.location.LocationGroup;
import com.blems.dream.api.model.part.PartType;
import com.blems.dream.api.model.product.ProductTree;
import com.blems.dream.api.model.tracking.PartTracking;
import com.blems.dream.api.model.uom.Uom;

public class PartInitDataWrapperDto {
	
	private List<ChartAccount> coaList;
	private List<Customer> defaultCustomers;
	private List<PartType> partTypes;
	private List<LocationGroup> locationGroup;
	private List<Uom> uom;
	private List<ProductTree> productTree;
	
	private List<PartTracking> partTrackings;
	
	public void addCoAList(ChartAccount coa){
		getCoaList().add(coa);
	}
	public void addDefaultCustomer(Customer customer){
		getDefaultCustomers().add(customer);
	}
	public void addPartType(PartType type){
		getPartTypes().add(type);
	}
	public void addLocationGroup(LocationGroup locationGroup){
		getLocationGroup().add(locationGroup);
	}
	public void addProductTree(ProductTree productTree){
		getProductTree().add(productTree);
	}
	public void addPartTracking(PartTracking partTracking){
		getPartTrackings().add(partTracking);
	}
	

	
	public List<ChartAccount> getCoaList() {
		if(coaList==null){
			coaList = new ArrayList<ChartAccount>();
		}
		return coaList;
	}
	public void setCoaList(List<ChartAccount> coaList) {
		this.coaList = coaList;
	}
	public List<Customer> getDefaultCustomers() {
		if(defaultCustomers==null){
			defaultCustomers = new ArrayList<Customer>();
		}
		return defaultCustomers;
	}
	public void setDefaultCustomers(List<Customer> defaultCustomers) {
		this.defaultCustomers = defaultCustomers;
	}
	public List<PartType> getPartTypes() {
		if(partTypes==null){
			partTypes = new ArrayList<PartType>();
		}
		return partTypes;
	}
	public void setPartTypes(List<PartType> partTypes) {
		this.partTypes = partTypes;
	}
	public List<LocationGroup> getLocationGroup() {
		if(locationGroup==null){
			locationGroup = new ArrayList<LocationGroup>();
		}
		return locationGroup;
	}
	public void setLocation(List<LocationGroup> locationGroup) {
		this.locationGroup = locationGroup;
	}
	public List<Uom> getUom() {
		return uom;
	}
	public void setUom(List<Uom> uom) {
		this.uom = uom;
	}
	public List<ProductTree> getProductTree() {
		if(productTree==null){
			productTree = new ArrayList<ProductTree>();
		}
		return productTree;
	}
	public void setProductTree(List<ProductTree> productTree) {
		this.productTree = productTree;
	}
	public List<PartTracking> getPartTrackings() {
		if(partTrackings==null){
			partTrackings = new ArrayList<>();
		}
		return partTrackings;
	}
	public void setPartTrackings(List<PartTracking> partTrackings) {
		this.partTrackings = partTrackings;
	}
	public void setLocationGroup(List<LocationGroup> locationGroup) {
		this.locationGroup = locationGroup;
	}
	
	
	
}
