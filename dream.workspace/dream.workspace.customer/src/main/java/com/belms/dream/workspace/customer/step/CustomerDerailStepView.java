package com.belms.dream.workspace.customer.step;

import com.belms.dream.api.dto.customer.CustomerInitDataWrapperDto;
import com.belms.dream.api.view.EntryView;
import com.belms.dream.workspace.common.newview.StepView;
import com.belms.dream.workspace.customer.subview.CustomerDetailView;
import com.blems.dream.api.model.customer.Customer;
import com.vaadin.ui.Component;

public class CustomerDerailStepView implements StepView<Customer> {

	private final static String NAME ="Customer Detail";
	private  EntryView<Customer> entryView;
	
	public CustomerDerailStepView(final CustomerInitDataWrapperDto initDataWrapperDto) {
		entryView = new CustomerDetailView(initDataWrapperDto);
	}

	@Override
	public boolean isValid() {
		return entryView.isValid();
	}

	@Override
	public Component getView() {
		return entryView.getView();
	}


	@Override
	public String getName() {
		return NAME;
	}

	@Override
	public boolean validationRequired() {
		return true;
	}

	@Override
	public void loadData(Customer data) {
		entryView.loadData(data);
		
	}

	@Override
	public boolean skipThisStep() {
		
		return false;
	}
	
}
 