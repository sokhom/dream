/***
 * @author ngounphanny
 * 
 */
package com.belms.dream.service.common.address;

import com.belms.dream.api.service.Service;
import com.belms.dream.api.service.ServiceFactory;
import com.belms.dream.api.service.address.AddressService;

public class AddressServiceFactory implements ServiceFactory {

	public String getId() {
		
		return AddressService.ID;
	}

	public Service<?> getService() {
		return new AddressServiceImpl();
	}

}
