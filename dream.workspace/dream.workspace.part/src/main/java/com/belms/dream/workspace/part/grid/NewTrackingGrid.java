package com.belms.dream.workspace.part.grid;

import java.util.Set;

import com.belms.dream.api.view.event.SaveEntityListener;
import com.belms.dream.workspace.part.AbstractGridCRUDButtonBar;
import com.blems.dream.api.model.tracking.PartTracking;
import com.vaadin.data.ValueProvider;
import com.vaadin.ui.Grid;
import com.vaadin.ui.Window;

public class NewTrackingGrid extends AbstractGridCRUDButtonBar<PartTracking> implements SaveEntityListener<PartTracking> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	public NewTrackingGrid() {
		
	}

	@Override
	public boolean isValid() {
		
		return true;
	}

	@Override
	protected String getTitle() {		
		return "Tracking";
	}

	@Override
	protected void initUI() {
		addColumn(PartTracking::getName).setCaption("Name");
		addColumn(PartTracking::getAbbr).setCaption("Abb");
		addColumn(PartTracking::getDescription).setCaption("Description");
		ValueProvider<PartTracking, String> dataProviderType = source -> source.getType().getName();		
		addColumn(dataProviderType).setCaption("Type");		
	}

	@Override
	protected void afterItemDeleted(Set<PartTracking> itemDeleted, Grid<PartTracking> grid) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected Window getNewView() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Window getEditView() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(PartTracking bean, SaveEntityListener.OPER_TYPE type) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public PartTracking getBean(SaveEntityListener.OPER_TYPE type) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
