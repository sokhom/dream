package com.belms.dream.repository.part;

import java.util.ArrayList;
import java.util.List;

import com.belms.dream.api.dto.part.PartInitDataWrapperDto;
import com.blems.dream.api.model.coa.ChartAccount;
import com.blems.dream.api.model.coa.CoAType;
import com.blems.dream.api.model.part.Part;
import com.blems.dream.api.model.part.PartToTracking;
import com.blems.dream.api.model.part.PartType;
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
		return partInit;
	}
	
	private void initPartList(){
		if(parts==null){
			parts = new ArrayList<>();
			parts.add(createPart(0, "BB-0012", new Uom(1, "ea"), new PartType(1, "Invetory")));
			parts.add(createPart(1, "AA-00125", new Uom(1, "ea"), new PartType(1, "Invetory")));
			parts.add(createPart(2, "CC-1200", new Uom(1, "ea"), new PartType(1, "Invetory")));
		}
	}
	
	private Part createPart(int id,String name,Uom uom,PartType partType){
		initDataPartToTracking();
		Part part = new Part();
		part.setId(id);
		part.setName(name);
		part.setUom(uom);
		part.setPartType(partType);
		part.setPartToTrackings(partToTrackings);
		return part;
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

}
