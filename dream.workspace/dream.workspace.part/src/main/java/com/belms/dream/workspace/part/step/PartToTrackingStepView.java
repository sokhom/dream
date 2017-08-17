package com.belms.dream.workspace.part.step;

import com.belms.dream.api.dto.part.PartInitDataWrapperDto;
import com.belms.dream.workspace.common.newview.StepView;
import com.belms.dream.workspace.part.grid.PartToTrackingGrid;
import com.blems.dream.api.model.part.Part;
import com.vaadin.data.Binder;
import com.vaadin.shared.ui.MarginInfo;
import com.vaadin.ui.Component;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;

public class PartToTrackingStepView implements StepView<Part>{

	private final Binder<Part> binder;
	private PartInitDataWrapperDto partInitDataWrapperDto;
	private PartToTrackingGrid trackingGrid;
	VerticalLayout vLayout;
	
	
	public PartToTrackingStepView(PartInitDataWrapperDto partInitDataWrapperDto) {
		this.binder = new Binder<>();
		this.partInitDataWrapperDto = partInitDataWrapperDto;
		
		 vLayout = new VerticalLayout();
			vLayout.setMargin(new MarginInfo(true, true));
			vLayout.setSizeFull();
//			Panel partPanel = new Panel();
//			partPanel.setSizeFull();
//			
//			partPanel.setCaption("Part Tracking");
		    trackingGrid = new PartToTrackingGrid(partInitDataWrapperDto);
//			partPanel.setContent(trackingGrid);
			vLayout.addComponent(trackingGrid);
	}
	
	@Override
	public boolean isValid() {		
		return false;
	}

	@Override
	public Component getView() {		
		return vLayout;
	}

	@Override
	public void loadData(Part data) {
		binder.setBean(data);		
		trackingGrid.loadData(data.getPartToTrackings());
	}

	@Override
	public String getName() {
		return "Setup part tracking";
	}

	@Override
	public boolean validationRequired() {		
		return false;
	}

}
