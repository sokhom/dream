package com.belms.dream.workspace.part.grid;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.belms.dream.api.dto.part.PartInitDataWrapperDto;
import com.belms.dream.api.view.EntryView;
import com.belms.dream.repository.part.PartRepo;
import com.blems.dream.api.model.part.PartToTracking;
import com.blems.dream.api.model.tracking.PartTracking;
import com.vaadin.data.ValueProvider;
import com.vaadin.data.provider.CallbackDataProvider;
import com.vaadin.data.provider.DataProvider;
import com.vaadin.ui.Component;
import com.vaadin.ui.Grid;

public class PartToTrackingGrid extends Grid<PartToTracking>  implements EntryView<List<PartToTracking>>{	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private PartInitDataWrapperDto partInitDataWrapper;
	private Map<String, PartToTracking> partToTrackingMap;
	
	
	public PartToTrackingGrid(PartInitDataWrapperDto partInitDataWrapper) {
		setSizeFull();		
		this.partInitDataWrapper = partInitDataWrapper;		
		addColumn(PartToTracking::isSelectedFlag).setCaption("Selected");
		ValueProvider<PartToTracking, String> trackingName = source->source.getPartTracking().getName();
		addColumn(trackingName).setCaption("Name");
		addColumn(PartToTracking::getNextValue).setCaption("Next Value");
		addColumn(PartToTracking::isPrimaryFlag).setCaption("Primary");
		
		
	}


	@Override
	public boolean isValid() {		
		return true;
	}


	@Override
	public Component getView() {
		
		return this;
	}


	@Override
	public void loadData(List<PartToTracking> data) {	
		addPartToTrackinIntoMap(data);
		List<PartTracking> partTrackings= partInitDataWrapper.getPartTrackings();
		List<PartToTracking> itemList =  data;
//		if(itemList==null){
//			itemList = new ArrayList<>();
//		}
		for (PartTracking partTracking : partTrackings) {
			String name = partTracking.getName();
			if(getPartToTracking(name)==null){
				PartToTracking pTT = new PartToTracking("", partTracking);
				itemList.add(pTT);
			}
		}
		
		DataProvider<PartToTracking, String> searchListDataProvider = new CallbackDataProvider<>(query -> itemList.stream(), query -> itemList.size());
		setDataProvider(searchListDataProvider);
	}
	
	private void addPartToTrackinIntoMap(List<PartToTracking> partToTrackings){
		if(partToTrackingMap==null){
			 partToTrackingMap = new HashMap<>();
			 
			 for (PartToTracking partTracking : partToTrackings) {
				 partToTrackingMap.put(partTracking.getPartTracking().getName(), partTracking);
			}
			 
		 }
	}
	private PartToTracking getPartToTracking(String name){
		 
		 return partToTrackingMap.get(name);
	}
	


}
