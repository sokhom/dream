package com.belms.dream.repository.part;

import java.util.ArrayList;
import java.util.List;

import com.belms.dream.api.dto.part.PartInitDataWrapperDto;
import com.blems.dream.api.model.coa.ChartAccount;
import com.blems.dream.api.model.coa.CoAType;
import com.blems.dream.api.model.location.Location;
import com.blems.dream.api.model.location.LocationGroup;
import com.blems.dream.api.model.location.LocationType;
import com.blems.dream.api.model.part.Part;
import com.blems.dream.api.model.part.PartToTracking;
import com.blems.dream.api.model.part.PartType;
import com.blems.dream.api.model.product.Product;
import com.blems.dream.api.model.tracking.PartTracking;
import com.blems.dream.api.model.tracking.PartTrackingType;
import com.blems.dream.api.model.uom.Uom;

import dream.repository.common.AbstractRepo;

public class PartRepo extends AbstractRepo<Part> implements IPartRepo {
	
	private List<Part> parts;
	private List<PartToTracking> partToTrackings;
	public List<Part> getAll() {
		initPartList();
		return parts;
	}
	
	

	@Override
	public Part getById(int id) {
		initPartList();
		return parts.get(id);
	}



	@Override
	public Part add(Part t) {
		initPartList();
		parts.add(t);
		t.setId(parts.size());
		return t;
	}

	@Override
	public void remove(Part t) {
		initPartList();
		parts.remove(t.getId());
		
	}

	@Override
	public Part edit(Part t) {		
		return super.edit(t);
	}

	@Override
	public PartInitDataWrapperDto getInitData() {
		
		return initDataWrapper();
	}
	
	private PartInitDataWrapperDto initDataWrapper(){
		PartInitDataWrapperDto partInit = new PartInitDataWrapperDto();
		partInit.addCoAList(new ChartAccount(0,"000001", "AccountsPayable", new CoAType("AccountsPayable")));
		partInit.addCoAList(new ChartAccount(0,"100001", "AccountsReceivable", new CoAType("AccountsReceivable")));
		partInit.addCoAList(new ChartAccount(0,"200001", "Bank", new CoAType("Bank")));
		partInit.addCoAList(new ChartAccount(0,"300001", "CostOfGoodsSold", new CoAType("CostOfGoodsSold")));
		partInit.addCoAList(new ChartAccount(0,"400001", "CreditCard", new CoAType("CreditCard")));
		
		LocationType cosignmentType = createLocationType("Consignment");
		LocationType shippingType = createLocationType("Shipping");
		LocationType stockType = createLocationType("Stock");
		LocationType receivingType = createLocationType("Receiving");
		LocationType storeFrontType = createLocationType("Store Front");
		LocationType inSpectionType = createLocationType("Inspection");
		LocationType LockedType = createLocationType("Locked");
		LocationType vendorType = createLocationType("Vendor");
		LocationType inTransitType = createLocationType("In Transit");
		// Consigment Group
		List<Location> consignments = new ArrayList<>();
		consignments.add(createLocation("Consignment 100",cosignmentType));
		consignments.add(createLocation("Shipping",shippingType));
		consignments.add(createLocation("Stock",stockType));
		consignments.add(createLocation("Receiving",receivingType));		
		partInit.addLocationGroup(createLocationGroup("Consignment UT",consignments));
		
		// LA Group
		List<Location> la = new ArrayList<>();
		la.add(createLocation("Store Front",storeFrontType));
		la.add(createLocation("Bike Returns",receivingType));
		la.add(createLocation("Bike Storage",stockType));
		la.add(createLocation("Bike Repair",stockType));
		la.add(createLocation("Receiving",receivingType));
		la.add(createLocation("Stock 100",stockType));
		la.add(createLocation("Stock 200",stockType));
		la.add(createLocation("Stock 300",stockType));
		la.add(createLocation("Shipping",shippingType));		
		partInit.addLocationGroup(createLocationGroup("LA",la));
//		Part Type
		List<PartType> partTypes = new ArrayList<>(); 
		partTypes.add(new PartType(10, "Inventory"));
		partTypes.add(new PartType(20, "Service"));
		partTypes.add(new PartType(40, "Non-Inventory"));
		partInit.setPartTypes(partTypes);
		
		return partInit;
	}
	
	private void initPartList(){
		if(parts==null){
			parts = new ArrayList<>();
			List<Product> bbProducts = new ArrayList<>();
			bbProducts.add(createProduct("BB-0012"));
			parts.add(createPart(0, "BB-0012", new Uom(1, "ea"), new PartType(1, "Invetory"),bbProducts));
			bbProducts = new ArrayList<>();
			bbProducts.add(createProduct("AA-00125"));
			parts.add(createPart(1, "AA-00125", new Uom(1, "ea"), new PartType(1, "Invetory"),bbProducts));
			bbProducts = new ArrayList<>();
			bbProducts.add(createProduct("CC-1200"));
			bbProducts.add(createProduct("CC-855"));
			parts.add(createPart(2, "CC-1200", new Uom(1, "ea"), new PartType(1, "Invetory"),bbProducts));
		}
	}
	
	private Part createPart(int id,String name,Uom uom,PartType partType,List<Product> products){
		initDataPartToTracking();
		Part part = new Part();
		part.setId(id);
		part.setName(name);
		part.setUom(uom);
		part.setPartType(partType);
		part.setPartToTrackings(partToTrackings);
		part.setProducts(products);
		return part;
	}
	
	private Product createProduct(String name){
		Product p = new Product();
		p.setName(name);
		return p;
	}
	
	private void initDataPartToTracking(){
		if(partToTrackings==null){
			partToTrackings = new ArrayList<>();
			partToTrackings.add(createPartToTracking("Lot100",new PartTracking("Lot#", "Lot Number", new PartTrackingType("Text"))));
			partToTrackings.add(createPartToTracking("200.Rev",new PartTracking("Rev#", "Revision Level", new PartTrackingType("Text"))));
		}
	}
	
	private PartToTracking createPartToTracking(String name,PartTracking partTracking){
		PartToTracking pToTrack = new PartToTracking(name, partTracking);	
		
		return pToTrack;
	}
	
	private LocationGroup createLocationGroup(String name,List<Location> locations){
		LocationGroup locGroup = new LocationGroup();
		locGroup.setName(name);
		locGroup.setLocations(locations);
		return locGroup;
	}
	
	private Location createLocation(String name,LocationType locType){
		Location loc = new Location();
		loc.setName(name);
		loc.setType(locType);
		return loc;
	}
	private LocationType createLocationType(String name){
		LocationType locType = new LocationType();
		locType.setName(name);
		return  locType;
	}

}
