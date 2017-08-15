package com.belms.dream.workspace.part.step;

import com.belms.dream.api.dto.part.PartInitDataWrapperDto;
import com.belms.dream.workspace.common.newview.StepView;
import com.belms.dream.workspace.part.PartGeneral;
import com.blems.dream.api.model.customer.Customer;
import com.blems.dream.api.model.part.Part;
import com.blems.dream.api.model.part.PartType;
import com.vaadin.data.Binder;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.Component;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Panel;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

public class PartInfoStepView implements StepView<Part>{


	private final  Binder<Part> binder;
	
	public PartInfoStepView() {
		binder = new Binder<>();
	}
	public boolean isValid() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Component getView() {
		VerticalLayout v = new VerticalLayout();
		
		Panel partPanel = new Panel();
		FormLayout frmLayout = new FormLayout();
		partPanel.setCaption("Part");
		partPanel.setContent(frmLayout);
		
	    final TextField numberText = new TextField("Number");
	    frmLayout.addComponent(numberText);
		
	    final ComboBox<PartType> partTypeComb = new ComboBox<PartType>("Type");		
		binder.forField(partTypeComb).bind(Part::getPartType, null);
		frmLayout.addComponent(partTypeComb);
		
		v.addComponent(partPanel);
		

		return v;
	}

	@Override
	public void loadData(Part data) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getName() {
		return "Part Info";
	}

	@Override
	public boolean validationRequired() {
		// TODO Auto-generated method stub
		return false;
	}

}
