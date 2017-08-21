package com.belms.dream.workspace.part.comps;

import java.util.List;

import com.belms.dream.api.dto.part.PartInitDataWrapperDto;
import com.belms.dream.api.view.EntryView;
import com.blems.dream.api.model.part.PartToTracking;
import com.blems.dream.api.model.tag.Tag;
import com.vaadin.data.Binder;
import com.vaadin.shared.ui.MarginInfo;
import com.vaadin.ui.Component;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

public class InventoryTrackingView extends VerticalLayout  implements EntryView<List<PartToTracking>>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private PartInitDataWrapperDto partInitDataWrapperDto;
	private Binder<List<PartToTracking>> binder;
	public InventoryTrackingView(PartInitDataWrapperDto partInitDataWrapperDto) {
		this.binder = new Binder<>();
		this.partInitDataWrapperDto = partInitDataWrapperDto;
		
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
		this.binder.setBean(data);
		initUI();
	}
	
	private void initUI(){
		final FormLayout formLayout = new FormLayout();
		formLayout.addStyleName(ValoTheme.FORMLAYOUT_LIGHT);
		formLayout.setMargin(new MarginInfo(true, true, false, true));
		addComponent(formLayout);
		
		final TextField lotText = new TextField("Lot Number");
		formLayout.addComponent(lotText);
		
	}
	
}
