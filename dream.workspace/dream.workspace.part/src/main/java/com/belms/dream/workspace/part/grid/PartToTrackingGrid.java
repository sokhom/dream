package com.belms.dream.workspace.part.grid;

import java.util.List;

import com.belms.dream.api.dto.part.PartInitDataWrapperDto;
import com.belms.dream.api.view.EntryView;
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
	
	
	public PartToTrackingGrid(PartInitDataWrapperDto partInitDataWrapper) {
		setSizeFull();		
		this.partInitDataWrapper = partInitDataWrapper;		
		ValueProvider<PartToTracking, String> trackingName = source->source.getPartTracking().getName();
		addColumn(trackingName).setCaption("Name");
		addColumn(PartToTracking::getNextValue).setCaption("Next Value");
	}


	@Override
	public boolean isValid() {
		
		return false;
	}


	@Override
	public Component getView() {
		
		return this;
	}


	@Override
	public void loadData(List<PartToTracking> data) {	
		List<PartTracking> partTrackings= partInitDataWrapper.getPartTrackings();
		List<PartToTracking> itemList =  data;
//		if(itemList==null){
//			itemList = new ArrayList<>();
//		}
		for (PartTracking partTracking : partTrackings) {
			PartToTracking pTT = new PartToTracking("", partTracking);
//			itemList.add(pTT);
		}
		
		DataProvider<PartToTracking, String> searchListDataProvider = new CallbackDataProvider<>(query -> itemList.stream(), query -> itemList.size());
		setDataProvider(searchListDataProvider);
	}
	


}
