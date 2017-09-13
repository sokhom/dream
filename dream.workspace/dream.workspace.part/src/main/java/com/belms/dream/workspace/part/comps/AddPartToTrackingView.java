package com.belms.dream.workspace.part.comps;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.belms.dream.api.view.event.SaveEntityListener;
import com.belms.dream.api.view.event.SaveEntityListener.OPER_TYPE;
import com.belms.dream.workspace.common.window.AbstractSimpleDialog;
import com.blems.dream.api.model.part.PartToTracking;
import com.blems.dream.api.model.tracking.PartTracking;
import com.vaadin.data.Binder;
import com.vaadin.data.provider.CallbackDataProvider;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Grid;
import com.vaadin.ui.Grid.SelectionMode;
import com.vaadin.ui.Notification;
import com.vaadin.ui.VerticalLayout;

public class AddPartToTrackingView extends AbstractSimpleDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<PartTracking> partTrackings;
	private SaveEntityListener<PartToTracking> saveEntityListener;
	private Binder<PartToTracking> binder;
//	final ComboBox<PartTracking> pTrackingComb = new ComboBox<PartTracking>("Part Tracking");
	final Grid<PartTracking> grid = new Grid<PartTracking>();
	public AddPartToTrackingView(SaveEntityListener<PartToTracking> saveEntityListener,OPER_TYPE operType, List<PartTracking> partTrackings) {
		binder = new Binder<PartToTracking>();
		this.partTrackings=partTrackings;
		this.saveEntityListener = saveEntityListener;
		setWidth(700, Unit.PIXELS);
		setHeight(700, Unit.PIXELS);
		setOpterationType(operType);
		binder.setBean(saveEntityListener.getBean(getOperationType()));
		
		// switch to multiselect mode
		grid.setSizeFull();
		grid.setSelectionMode(SelectionMode.MULTI);
		grid.addSelectionListener(event -> {
		    Set<PartTracking> selected = event.getAllSelectedItems();
		    Notification.show(selected.size() + " items selected");
		});
		grid.addColumn(PartTracking::getAbbr).setCaption("Abbr");
		grid.addColumn(PartTracking::getType).setCaption("Type");
		loadData(partTrackings);
	}

	
	@Override
	protected String getDialogCaption() {
		
		return "Part Tracking";
	}

	@Override
	protected void buildContentLayout(VerticalLayout parent) {		
		
//		parent.addComponent(pTrackingComb);
		parent.addComponent(grid);
		
		final ClickListener clickListener = new ClickListener() {
			
			@Override
			public void buttonClick(ClickEvent event) {
				// TODO Auto-generated method stub
				
			}
		};
		setOkButtonClickListener(event -> {
//			if(!binder.validate().isOk()) {
//				Notification.show("Input data is not valid", Type.ERROR_MESSAGE);
//				return;
//			}
		
			Set<PartTracking> selectItems= grid.getSelectedItems();
			for (Iterator<PartTracking> iterator = selectItems.iterator(); iterator.hasNext();) {
				PartTracking partTracking =  iterator.next();
				PartToTracking pToTracking =saveEntityListener.getBean(getOperationType());			
				pToTracking.setPartTracking(partTracking);
				saveEntityListener.save(pToTracking, getOperationType());
				
			}
			
			close();
//			binder.setBean(saveEntityListener.getBean(getOperationType()));
//			addressTypeComboBox.focus();
//			if(OPER_TYPE.EDIT == getOperationType()) {
//				close();
//			}
		});
		
	}
	
	public void loadData(List<PartTracking> partTrackings){
//		pTrackingComb.setDataProvider(new CallbackDataProvider<PartTracking, String>(query->partTrackings.stream(), qyery->partTrackings.size()));
		
		grid.setDataProvider(new CallbackDataProvider<PartTracking, String>(query->partTrackings.stream(), qyery->partTrackings.size()));
	}
	
	public void setDataFilter(DataFilter dataFilter){	
		loadData(dataFilter.getDataFilter(partTrackings));
	}
	
	 public interface DataFilter extends Serializable {
		 public List<PartTracking>  getDataFilter(List<PartTracking> partTrackings);	
		 
	 }

}
