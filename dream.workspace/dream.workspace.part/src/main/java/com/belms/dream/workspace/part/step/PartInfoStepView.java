package com.belms.dream.workspace.part.step;

import com.belms.dream.api.dto.part.PartInitDataWrapperDto;
import com.belms.dream.workspace.common.newview.StepView;
import com.belms.dream.workspace.part.PartGeneral;
import com.belms.dream.workspace.part.comps.ProductView;
import com.blems.dream.api.model.part.Part;
import com.vaadin.data.Binder;
import com.vaadin.ui.Component;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;

public class PartInfoStepView implements StepView<Part>{


	private final  Binder<Part> binder;
	private PartInitDataWrapperDto partInitDataWrapperDto;
	private VerticalLayout v;
	private PartGeneral partGeneral;
	public PartInfoStepView(PartInitDataWrapperDto partInitDataWrapperDto) {
		binder = new Binder<>();
		this.partInitDataWrapperDto = partInitDataWrapperDto;
		
		v = new VerticalLayout();
		
		Panel partPanel = new Panel();
		partPanel.setCaption("Part");
		partGeneral = new PartGeneral(partInitDataWrapperDto);
		partPanel.setContent(partGeneral);	
		
		Panel productPanel = new Panel();
		productPanel.setCaption("Product");
		ProductView productLayout = new ProductView(partInitDataWrapperDto);
		productPanel.setContent(productLayout);	
	   /* final TextField numberText = new TextField("Number");
	    frmLayout.addComponent(numberText);
		
	    final ComboBox<PartType> partTypeComb = new ComboBox<PartType>("Type");		
		binder.forField(partTypeComb).bind(Part::getPartType, Part::setPartType);
		partTypeComb.setDataProvider(new CallbackDataProvider<PartType,String>(query->partInitDataWrapperDto.getPartTypes().stream(),query->partInitDataWrapperDto.getPartTypes().size()));
		frmLayout.addComponent(partTypeComb);*/
		
		v.addComponent(partPanel);
		v.addComponent(productPanel);
	}
	public boolean isValid() {		
		return true;
	}

	@Override
	public Component getView() {

		return v;
	}

	@Override
	public void loadData(Part data) {
		binder.setBean(data);
		partGeneral.loadData(data);
		
	}

	@Override
	public String getName() {
		return "Part Info / Product Info";
	}

	@Override
	public boolean validationRequired() {
		
		return false;
	}
	@Override
	public boolean skipThisStep() {
		
		return false;
	}

}
