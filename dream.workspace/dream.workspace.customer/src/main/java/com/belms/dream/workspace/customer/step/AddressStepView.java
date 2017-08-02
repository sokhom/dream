package com.belms.dream.workspace.customer.step;

import com.belms.dream.api.dto.address.AddressInitDataWrapperDto;
import com.belms.dream.workspace.common.address.AddressView;
import com.belms.dream.workspace.common.address.AddressViewImpl;
import com.belms.dream.workspace.common.newview.StepView;
import com.blems.dream.api.model.customer.Customer;
import com.vaadin.ui.Component;

public class AddressStepView implements StepView<Customer> {

	private final static String NAME="Address";
	private final AddressView addressView;
	
	public AddressStepView(final AddressInitDataWrapperDto initDataWrapperDto) {
		addressView =  new AddressViewImpl(initDataWrapperDto);
		addressView.initView();
	}
	
	@Override
	public String getName() {
		return NAME;
	}

	@Override
	public boolean isValid() {
		return addressView.isValid();
	}


	@Override
	public boolean validationRequired() {
		return false;
	}

	@Override
	public Component getView() {
		return addressView.getView();
	}

	@Override
	public void loadData(Customer data) {
		addressView.loadData(data.getAddresses());
	}


}
