/***
 * @author ngounphanny
 * 
 */
package com.belms.dream.workspace.common.address;

import java.util.List;

import com.blems.dream.api.model.address.Address;

public interface LoadAddressesListener {
	void loaded(List<Address> addresses);

}
