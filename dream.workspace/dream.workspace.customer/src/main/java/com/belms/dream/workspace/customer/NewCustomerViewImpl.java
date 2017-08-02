package com.belms.dream.workspace.customer;

import java.util.ArrayList;
import java.util.List;

import com.belms.dream.api.dto.address.AddressInitDataWrapperDto;
import com.belms.dream.api.dto.customer.CustomerInitDataWrapperDto;
import com.belms.dream.api.view.event.AddnewEntityListener;
import com.belms.dream.api.view.event.EventBusProvider;
import com.belms.dream.workspace.common.newview.AbstractNewView;
import com.belms.dream.workspace.common.newview.StepView;
import com.belms.dream.workspace.customer.step.AddressStepView;
import com.belms.dream.workspace.customer.step.CustomerDerailStepView;
import com.belms.dream.workspace.customer.step.CustomerInfoStepView;
import com.blems.dream.api.model.customer.Customer;

public class NewCustomerViewImpl extends AbstractNewView<Customer> implements NewCustomerView {

	private static final long serialVersionUID = 1L;
	private final CustomerInitDataWrapperDto customerInitDataWrapperDto;
	private final AddressInitDataWrapperDto addressInitDataWrapperDto;
	private final static String CAPTION = "<h3><b>New Customer wizard</b></h3>";
	private Customer customer;

	public NewCustomerViewImpl(final EventBusProvider eventBusProvider, 
			final CustomerInitDataWrapperDto customerInitDataWrapperDto,
			final AddressInitDataWrapperDto addressInitDataWrapperDto) {
		super(eventBusProvider);
		this.customerInitDataWrapperDto = customerInitDataWrapperDto;
		this.addressInitDataWrapperDto = addressInitDataWrapperDto;
		eventBusProvider.register(this);
		setCaption(CAPTION);
		setCaptionAsHtml(true);
		center();
		setWidth(900, Unit.PIXELS);
		setHeight(700, Unit.PIXELS);
		
		customer = new Customer();
		customer.setAddresses(new ArrayList<>());
		
		initView();
	}

	@Override
	protected List<StepView<Customer>> getStepViews() {
		List<StepView<Customer>> stepViews = new ArrayList<>();
		stepViews.add(new CustomerInfoStepView());
		stepViews.add(new CustomerDerailStepView(customerInitDataWrapperDto));
		stepViews.add(new AddressStepView(addressInitDataWrapperDto));
		
		for (StepView<Customer> stepView : stepViews) {
			stepView.loadData(customer);
		}
		
		return stepViews;
	}

	@Override
	public void setAddNewListener(AddnewEntityListener<Customer> addNewCustomerListener) {
		setAddnewEntityListener(addNewCustomerListener);
	}

	@Override
	protected Customer getNewItem() {
		return customer;
	}

	

}
