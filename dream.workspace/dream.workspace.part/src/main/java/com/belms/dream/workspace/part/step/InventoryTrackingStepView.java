package com.belms.dream.workspace.part.step;

import com.belms.dream.api.dto.part.PartInitDataWrapperDto;
import com.belms.dream.api.view.event.SaveEntityListener;
import com.belms.dream.workspace.common.newview.StepView;
import com.belms.dream.workspace.part.comps.InventoryTrackingView;
import com.blems.dream.api.model.part.Part;
import com.blems.dream.api.model.tag.Tag;
import com.vaadin.ui.Component;
import com.vaadin.ui.VerticalLayout;

public class InventoryTrackingStepView implements StepView<Part>,SaveEntityListener<Tag>{

	private VerticalLayout vLayout;
	private PartInitDataWrapperDto partInitDataWrapperDto;
	private InventoryTrackingView	tagTrackingView ;
	private Part part;
	public InventoryTrackingStepView(PartInitDataWrapperDto partInitDataWrapperDto) {
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
		this.part = data;
		tagTrackingView.loadData(data);
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
		String partNumber = part.getName();
		if(partNumber!=null && !partNumber.isEmpty()){
			return false;
		}
		return true;
	}
	
	@Override
	public void save(Tag bean, OPER_TYPE type) {		
		
	}
	@Override
	public Tag getBean(OPER_TYPE type) {	
		return new Tag();
	}
	private void initUI(){
		tagTrackingView = new InventoryTrackingView(this,OPER_TYPE.ADD,partInitDataWrapperDto);
		vLayout = new VerticalLayout();
		vLayout.addComponent(tagTrackingView);
	}

}
