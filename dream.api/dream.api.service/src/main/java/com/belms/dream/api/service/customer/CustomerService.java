package com.belms.dream.api.service.customer;

import com.belms.dream.api.dto.customer.CustomerInitDataWrapperDto;
import com.belms.dream.api.service.CrudService;
import com.blems.dream.api.model.customer.Customer;

public interface CustomerService extends CrudService<Customer> {
	public static final String ID="CUSTOMER_SERVICE";
	
	CustomerInitDataWrapperDto getInitData();
	
}
