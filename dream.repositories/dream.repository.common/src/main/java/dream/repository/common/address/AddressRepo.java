/***
 * @author ngounphanny
 * 
 */
package dream.repository.common.address;

import java.util.List;

import com.belms.dream.api.dto.address.AddressInitDataWrapperDto;
import com.blems.dream.api.model.address.Address;

import dream.repository.common.Repo;

public interface AddressRepo  extends Repo<Address>{
	
	List<Address> getAddressesByAccount(int accountId);
	AddressInitDataWrapperDto getInitData();

}
