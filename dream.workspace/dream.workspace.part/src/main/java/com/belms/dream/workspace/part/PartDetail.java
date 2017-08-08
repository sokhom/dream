package com.belms.dream.workspace.part;

import com.belms.dream.api.dto.part.PartInitDataWrapperDto;
import com.belms.dream.api.view.EntryView;
import com.blems.dream.api.model.part.Part;
import com.blems.dream.api.model.part.PartToTracking;
import com.blems.dream.api.model.tracking.PartTracking;
import com.vaadin.data.Binder;
import com.vaadin.data.ValueProvider;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.shared.ui.MarginInfo;
import com.vaadin.ui.Component;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Grid;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

public class PartDetail extends VerticalLayout  implements EntryView<Part>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final Binder<Part> binder;
	private final Grid<PartToTracking> trackingGrid;
	
	public PartDetail(PartInitDataWrapperDto partInitDataWrapper) {
		binder = new Binder<>();
		trackingGrid = getTrackingGrid();
		addStyleName("profile-form");
		setIcon(VaadinIcons.USER);
		setCaption("Detail");
		initUI();
		
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
	public void loadData(Part data) {
		binder.setBean(data);
		
	}
	private void initUI(){
		
		final FormLayout formLayout = new FormLayout();
		formLayout.addStyleName(ValoTheme.FORMLAYOUT_LIGHT);
		formLayout.setMargin(new MarginInfo(true, true, false, true));
		addComponent(formLayout);
	
		final TextField revisionText = new TextField("Revision");		
//		binder.bind(nameTextField, Part::getName, Part::setName);
		formLayout.addComponent(revisionText);
		
		final TextField createdDate = new TextField("Created Date");		
//		binder.bind(nameTextField, Part::getName, Part::setName);
		formLayout.addComponent(createdDate);
		
		
		formLayout.addComponent(trackingGrid);
		
	}
	
	private Grid<PartToTracking> getTrackingGrid(){
		Grid<PartToTracking> grid = new Grid<>("Tracking");

		grid.addColumn(PartToTracking::getNextValue).setCaption("NextValue");
		grid.addColumn(PartToTracking::isPrimaryFlag).setCaption("Primary");
		return grid;
	}

}
