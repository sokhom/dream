package com.belms.dream.workspace.part.step;

import com.belms.dream.api.dto.part.PartInitDataWrapperDto;
import com.belms.dream.workspace.common.newview.StepView;
import com.belms.dream.workspace.part.comps.InitInventoryView;
import com.belms.dream.workspace.part.grid.PartToTrackingGrid;
import com.blems.dream.api.model.part.Part;
import com.blems.dream.api.model.part.PartCost;
import com.blems.dream.api.model.tag.Tag;
import com.vaadin.data.Binder;
import com.vaadin.ui.Component;
import com.vaadin.ui.VerticalLayout;

public class PartInitInventoryStepView implements StepView<Part> {

	private final Binder<Tag> binder;
	private PartInitDataWrapperDto partInitDataWrapperDto;
	
	VerticalLayout vLayout;
	private InitInventoryView initInventoryView;
	
	public PartInitInventoryStepView(PartInitDataWrapperDto partInitDataWrapperDto) {
		this.binder = new Binder<>();
		this.partInitDataWrapperDto = partInitDataWrapperDto;
		
		initUI();
	}
	
	@Override
	public boolean isValid() {
		
		return true;
	}

	@Override
	public Component getView() {
		
		return vLayout;
	}

	@Override
	public void loadData(Part data) {
		PartCost partCost = new PartCost();
		data.setPartCost(partCost);
		Tag tage = new Tag();
		tage.setPart(data);
		data.getTags().add(tage);
		initInventoryView.loadData(tage);
		
	}

	@Override
	public String getName() {
		return "Add initail inventory";
	}

	@Override
	public boolean validationRequired() {
		
		return false;
	}
	
	@Override
	public boolean skipThisStep() {
		
		return false;
	}

	private void initUI(){
		initInventoryView = new InitInventoryView(partInitDataWrapperDto);
		vLayout = new VerticalLayout();
		vLayout.addComponent(initInventoryView);
	}

}
