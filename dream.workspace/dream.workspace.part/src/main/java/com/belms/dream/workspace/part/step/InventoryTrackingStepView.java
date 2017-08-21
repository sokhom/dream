package com.belms.dream.workspace.part.step;

import com.belms.dream.api.dto.part.PartInitDataWrapperDto;
import com.belms.dream.workspace.common.newview.StepView;
import com.belms.dream.workspace.part.comps.InitInventoryView;
import com.belms.dream.workspace.part.comps.InventoryTrackingView;
import com.blems.dream.api.model.part.Part;
import com.vaadin.ui.Component;
import com.vaadin.ui.VerticalLayout;

public class InventoryTrackingStepView implements StepView<Part>{

	private VerticalLayout vLayout;
	private PartInitDataWrapperDto partInitDataWrapperDto;
	private InventoryTrackingView	tagTrackingView ;
	public InventoryTrackingStepView(PartInitDataWrapperDto partInitDataWrapperDto) {
		this.partInitDataWrapperDto = partInitDataWrapperDto;
		initUI();
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
		tagTrackingView.loadData(data.getPartToTrackings());
	}

	@Override
	public String getName() {
		
		return "Inital Inventory tracking";
	}

	@Override
	public boolean validationRequired() {
		
		return false;
	}
	
	@Override
	public boolean skipThisStep() {
		
		return true;
	}
	private void initUI(){
		tagTrackingView = new InventoryTrackingView(partInitDataWrapperDto);
		vLayout = new VerticalLayout();
		vLayout.addComponent(tagTrackingView);
	}

}
