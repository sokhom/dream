package com.belms.dream.workspace.part.grid;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.belms.dream.api.dto.part.PartInitDataWrapperDto;
import com.belms.dream.api.view.event.SaveEntityListener;
import com.belms.dream.workspace.part.AbstractGridCRUDButtonBar;
import com.belms.dream.workspace.part.comps.AddPartToTrackingView;
import com.blems.dream.api.model.part.PartToTracking;
import com.blems.dream.api.model.tracking.PartTracking;
import com.vaadin.data.ValueProvider;
import com.vaadin.ui.Component;
import com.vaadin.ui.Grid;
import com.vaadin.ui.Window;

public class PartToTrackingGrid extends AbstractGridCRUDButtonBar<PartToTracking> implements SaveEntityListener<PartToTracking> {	
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
//		ValueProvider<PartToTracking, String> isSelected = source->source.isSelectedFlag()+"";
//		ButtonRenderer<PartToTracking> btnRenderer = new ButtonRenderer<>(new RendererClickListener<PartToTracking>(){			/**
//			 * 
//			 */
//			private static final long serialVersionUID = 1L;
//
//			@Override
//			public void click(RendererClickEvent<PartToTracking> event) {
//				PartToTracking item = event.getItem();
//				 boolean isSelected = item.isSelectedFlag();
//				 event.getItem().setSelectedFlag(!isSelected);
//				 getDataProvider().refreshItem(item);
//				
//			}
//			
//		});
//		
//	
//		
//		addColumn(isSelected,btnRenderer);
		
		
	}

	@Override
	public void save(PartToTracking bean, OPER_TYPE type) {
		
		addItem(bean);		
	}


	@Override
	public PartToTracking getBean(OPER_TYPE type) {
		if(OPER_TYPE.ADD==type){
			return new PartToTracking();
		}
		return null;
	}


	@Override
	protected String getTitle() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	protected void initUI() {
		// TODO Auto-generated method stub
		
	}


	@Override
	protected void afterItemDeleted(Set<PartToTracking> itemDeleted, Grid<PartToTracking> grid) {
		// TODO Auto-generated method stub
		
	}


	@Override
	protected Window getNewView() {
		AddPartToTrackingView window = new AddPartToTrackingView(this,OPER_TYPE.ADD,this.partInitDataWrapper.getPartTrackings());		
		window.setDataFilter(event->{
			final Map<String, PartToTracking> map= addPartToTrackinIntoMap(getDataList());
			List<PartTracking> list = new ArrayList<>();
			for (Iterator<PartTracking> iterator = event.iterator(); iterator.hasNext();) {
				PartTracking partTracking =  iterator.next();
				if(map.get(partTracking.getName())==null){
					list.add(partTracking);
				}
				System.out.println(partTracking.getName());
			}
			return list; 
		});
		window.initView();
		return window;
	}


	@Override
	protected Window getEditView() {		
		return null;
	}
	@Override
	public boolean isValid() {		
		return true;
	}


	@Override
	public Component getView() {
		
		return this;
	}

	

	/*@Override
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
	}*/
	
	private Map<String, PartToTracking>  addPartToTrackinIntoMap(List<PartToTracking> partToTrackings){
		
		Map<String, PartToTracking>  partToTrackingMap = new HashMap<>();
		
		for (PartToTracking partTracking : partToTrackings) {
			partToTrackingMap.put(partTracking.getPartTracking().getName(), partTracking);
		}
		return partToTrackingMap;
	}
	private PartToTracking getPartToTracking(String name){
		 
		 return partToTrackingMap.get(name);
	}
	
	


}
