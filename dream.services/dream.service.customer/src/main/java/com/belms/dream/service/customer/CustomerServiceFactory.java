/***
 * @author ngounphanny
 * 
 */
package com.belms.dream.service.customer;

import com.belms.dream.api.service.Service;
import com.belms.dream.api.service.ServiceFactory;
import com.belms.dream.api.service.customer.CustomerService;
import com.blems.dream.api.model.customer.Customer;

public class CustomerServiceFactory implements ServiceFactory{
	
	Service<Customer> service;
	
	public String getId() {

		return CustomerService.ID;
	}
	public Service<Customer> getService() {
		
		if(service == null){
			service = new CustomerServiceImpl();
			System.out.println("create custoomer service");	
		}else{
			System.out.println("load cache service");
		}
		
		return service;
	}
	

}
