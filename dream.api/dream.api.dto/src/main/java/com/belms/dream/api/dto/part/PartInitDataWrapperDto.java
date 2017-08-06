package com.belms.dream.api.dto.part;

import java.util.ArrayList;
import java.util.List;

import com.blems.dream.api.model.coa.ChartAccount;
import com.blems.dream.api.model.customer.Customer;
import com.blems.dream.api.model.location.Location;
import com.blems.dream.api.model.part.PartType;
import com.blems.dream.api.model.product.ProductTree;
import com.blems.dream.api.model.uom.Uom;

public class PartInitDataWrapperDto {
	
	private List<ChartAccount> coaList;
	private List<Customer> defaultCustomers;
	private List<PartType> partTypes;
	private List<Location> location;
	private List<Uom> uom;
	private List<ProductTree> productTree;
	
	public void addCoAList(ChartAccount coa){
		getCoaList().add(coa);
	}
	public void addDefaultCustomer(Customer customer){
		getDefaultCustomers().add(customer);
	}
	public void addPartType(PartType type){
		getPartTypes().add(type);
	}
	public void addLocation(Location location){
		getLocation().add(location);
	}
	public void addProductTree(ProductTree productTree){
		getProductTree().add(productTree);
	}
	public List<ChartAccount> getCoaList() {
		if(coaList==null){
			coaList = new ArrayList();
		}
		return coaList;
	}
	public void setCoaList(List<ChartAccount> coaList) {
		this.coaList = coaList;
	}
	public List<Customer> getDefaultCustomers() {
		if(defaultCustomers==null){
			defaultCustomers = new ArrayList();
		}
		return defaultCustomers;
	}
	public void setDefaultCustomers(List<Customer> defaultCustomers) {
		this.defaultCustomers = defaultCustomers;
	}
	public List<PartType> getPartTypes() {
		if(partTypes==null){
			partTypes = new ArrayList();
		}
		return partTypes;
	}
	public void setPartTypes(List<PartType> partTypes) {
		this.partTypes = partTypes;
	}
	public List<Location> getLocation() {
		if(location==null){
			location = new ArrayList();
		}
		return location;
	}
	public void setLocation(List<Location> location) {
		this.location = location;
	}
	public List<Uom> getUom() {
		return uom;
	}
	public void setUom(List<Uom> uom) {
		this.uom = uom;
	}
	public List<ProductTree> getProductTree() {
		if(productTree==null){
			productTree = new ArrayList();
		}
		return productTree;
	}
	public void setProductTree(List<ProductTree> productTree) {
		this.productTree = productTree;
	}
	
	
	
}
