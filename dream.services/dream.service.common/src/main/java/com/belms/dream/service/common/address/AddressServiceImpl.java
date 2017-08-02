/***
 * @author ngounphanny
 * 
 */
package com.belms.dream.service.common.address;

import java.util.List;

import com.belms.dream.api.dto.address.AddressInitDataWrapperDto;
import com.belms.dream.api.service.address.AddressService;
import com.blems.dream.api.model.address.Address;

import dream.repository.common.address.AddressRepo;
import dream.repository.common.address.AddressRepoImpl;

public class AddressServiceImpl implements AddressService {
	
	private final AddressRepo  addressRepo = new AddressRepoImpl();

	public Address add(Address t) {
		// TODO Auto-generated method stub
		return null;
	}

	public void remove(Address t) {
		// TODO Auto-generated method stub
		
	}

	public void edit(Address t) {
	}

	public Address getById(int id) {
		return null;
	}

	public List<Address> getAll() {
		return null;
	}

	public List<Address> getListAccountId(int accountId) {
		return addressRepo.getAddressesByAccount(accountId);
	}

	public AddressInitDataWrapperDto getInitData() {
		return addressRepo.getInitData();
	}
	


}
