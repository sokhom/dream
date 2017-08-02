/***
 * @author ngounphanny
 * 
 */

package com.belms.dream.workspace.common.address;

import java.util.List;

import com.blems.dream.api.model.address.Address;

public class AddressViewPresenter implements LoadAddressesListener {

//	private final AddressView addressView;
	//private final AddressService addressService;
	
//	public AddressViewPresenter(AddressView addressView,AddressService addressService) {
//		this.addressView = addressView;
//		this.addressService = addressService;
//		
//		addressView.setInitDataWrapperDto(addressService.getInitData());
//	}
//	
	public AddressViewPresenter(final AddressView addressView) {
//		this.addressView = addressView;
	}
	
	@Override
	public void loaded(List<Address> addresses) {
//		List<Address> addresses = addressService.getListAccountId(accountId);
		
		
		
	}

}
