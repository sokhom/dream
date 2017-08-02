/***
 * @author ngounphanny
 * 
 */
package com.belms.dream.service.customer;

import java.util.List;

import com.belms.dream.api.dto.customer.CustomerInitDataWrapperDto;
import com.belms.dream.api.service.customer.CustomerService;
import com.belms.dream.repository.customer.CustomerRepo;
import com.blems.dream.api.model.customer.Customer;

public class CustomerServiceImpl implements CustomerService {

	private CustomerRepo customerRepo = new CustomerRepo();
	
	public Customer add(Customer t) {
		return customerRepo.add(t);
	}

	public void remove(Customer t) {
		
	}
	public List<Customer> getAll() {
		return customerRepo.getAll();
	}

	public Customer getById(int id) {
		return customerRepo.getById(id);
	}

	public void edit(Customer t) {
		
	}

	public CustomerInitDataWrapperDto getInitData() {
		return customerRepo.getInitData();
	}

}
