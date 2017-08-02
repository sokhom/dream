/***
 * @author ngounphanny
 * 
 */
package com.belms.dream.workspace.customer;

import java.util.ArrayList;

import com.belms.dream.api.dto.address.AddressInitDataWrapperDto;
import com.belms.dream.api.dto.customer.CustomerInitDataWrapperDto;
import com.belms.dream.api.view.EntryView;
import com.belms.dream.api.view.event.EventBusProvider;
import com.belms.dream.workspace.common.address.AddressView;
import com.belms.dream.workspace.common.address.AddressViewImpl;
import com.belms.dream.workspace.common.mainview.AbstractMainView;
import com.belms.dream.workspace.customer.subview.CustomerDetailView;
import com.belms.dream.workspace.customer.subview.CustomerInfoView;
import com.blems.dream.api.model.customer.Customer;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

public class CustomerViewImpl extends AbstractMainView<Customer, Customer, CustomerInitDataWrapperDto> implements CustomerView {

	private static final long serialVersionUID = 1L;
	private AddressView addressView ;	
	private AddressInitDataWrapperDto initDataWrapperDto;
	private CustomerMainLayoutPresenter customerMainLayoutPresenter;
	
	public CustomerViewImpl(final EventBusProvider eventBusProvider) {
		super(eventBusProvider);
		customerMainLayoutPresenter =new CustomerMainLayoutPresenter(this);
		this.setFilterListener(customerMainLayoutPresenter);
		this.setShowItemListener(customerMainLayoutPresenter);
		this.setSaveEntityListener(customerMainLayoutPresenter);
		this.setRefreshEntityListener(customerMainLayoutPresenter);
	}

	
	@Override
	public void initView() {
		super.initView();
		buildTabs();
	}

	protected void buildTabs() {
		EntryView<Customer> entryView = new CustomerInfoView(getDataInitWrapper());
		addTab(entryView);
		entryView =new CustomerDetailView(getDataInitWrapper());
		addTab(entryView);
		addressView  =new AddressViewImpl(initDataWrapperDto);
		addressView.setContactHeight(300.0f);
		addressView.initView();
		addTab((VerticalLayout)addressView);
		
	}
	
	@Override
	public void loadData(Customer data) {
		super.loadData(data);
		
		if(data.getAddresses() == null) {
			data.setAddresses(new ArrayList<>());
		}
		
		this.addressView.loadData(data.getAddresses());
	}

	@Override
	public Window getNewView() {

		NewCustomerView customerView = new NewCustomerViewImpl(super.getEventBusProvider() , getDataInitWrapper(),initDataWrapperDto);
		customerView.setAddNewListener(customerMainLayoutPresenter);
		return  (Window) customerView;
	}



	@Override
	public void setAddressInitDataWrapperDto(AddressInitDataWrapperDto initDataWrapperDto) {
		this.initDataWrapperDto = initDataWrapperDto;
		
	}


	


}
