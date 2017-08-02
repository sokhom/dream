package com.belms.dream.api.service.address;

import java.util.List;

import com.belms.dream.api.dto.address.AddressInitDataWrapperDto;
import com.belms.dream.api.service.CrudService;
import com.blems.dream.api.model.address.Address;

public interface AddressService extends  CrudService<Address> {
	
	public final static String ID = "ADDRESS_SERVICE";
	
	List<Address> getListAccountId(int accountId); 
	AddressInitDataWrapperDto getInitData();

}
