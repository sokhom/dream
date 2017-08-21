package com.belms.dream.workspace.part.step;

import com.belms.dream.api.dto.part.PartInitDataWrapperDto;
import com.belms.dream.workspace.common.newview.StepView;
import com.belms.dream.workspace.part.PartLocation;
import com.blems.dream.api.model.location.Location;
import com.blems.dream.api.model.part.Part;
import com.vaadin.data.Binder;
import com.vaadin.ui.Component;
import com.vaadin.ui.VerticalLayout;

public class DefaultLocationStepView implements StepView<Part>{

	private VerticalLayout vLayout;
	private PartInitDataWrapperDto partInitDataWrapperDto;
	private Binder<Location> binder;
	public DefaultLocationStepView(PartInitDataWrapperDto partInitDataWrapperDto) {
		binder = new Binder<>();
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getName() {
		return "Default location";
	}

	@Override
	public boolean validationRequired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean skipThisStep() {
		
		return false;
	}
	
	private void initUI(){
		vLayout = new VerticalLayout();
		PartLocation partLocation = new PartLocation(partInitDataWrapperDto);
		vLayout.addComponent(partLocation);
	}

}
