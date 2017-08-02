/***
 * @author ngounphanny
 * 
 */
package dream.repository.common.address;

import java.util.ArrayList;
import java.util.List;

import com.belms.dream.api.dto.address.AddressInitDataWrapperDto;
import com.blems.dream.api.model.address.Address;
import com.blems.dream.api.model.address.AddressType;
import com.blems.dream.api.model.address.Country;
import com.blems.dream.api.model.address.State;
import com.blems.dream.api.model.contact.ContactType;

import dream.repository.common.AbstractRepo;

public class AddressRepoImpl extends AbstractRepo<Address> implements AddressRepo {

	public List<Address> getAddressesByAccount(int accountId) {
		
		return createAddresses();
	}
	
	private List<Address> createAddresses(){
		
		List<Address> addresses = new ArrayList<Address>();
		
		Address address = new Address();
		address.setName("Phanny Co.LTD");
		address.setAddress("#434, st. 223 Sangkat Roka knong, Kan Doun Keo");
		address.setCity("Takeo");
		address.setCountry(new Country(1,"Cambodia"));
		
		addresses.add(address);
		
		address = new Address();
		address.setName("Phanny1 Co.LTD");
		address.setAddress("#434, st. 223 Sangkat Roka knong, Kan Doun Keo");
		address.setCity("Takeo");
		address.setCountry(new Country(1,"Cambodia"));
		
		addresses.add(address);
		
		return addresses;
	}

	public AddressInitDataWrapperDto getInitData() {
		return creadInitData();
	}
	
	private AddressInitDataWrapperDto creadInitData(){
		
		AddressInitDataWrapperDto addressInitDataWrapperDto = new AddressInitDataWrapperDto();
		
		addressInitDataWrapperDto.addAddressType(new AddressType(10, "Ship To"));
		addressInitDataWrapperDto.addAddressType(new AddressType(20, "Bill To"));
		addressInitDataWrapperDto.addAddressType(new AddressType(30, "Remit To"));
		addressInitDataWrapperDto.addAddressType(new AddressType(40, "Home"));
		addressInitDataWrapperDto.addAddressType(new AddressType(50, "Main Office"));
		
		addressInitDataWrapperDto.addCountry(new Country(1, "Cambodia"));
		addressInitDataWrapperDto.addCountry(new Country(2, "The united state"));
		addressInitDataWrapperDto.addCountry(new Country(3, "France"));
		
		addressInitDataWrapperDto.addState(new State(1,"N/A"));
		
		
		addressInitDataWrapperDto.addContactType( new ContactType(10,"Home"));
		addressInitDataWrapperDto.addContactType( new ContactType(20,"Work"));
		addressInitDataWrapperDto.addContactType( new ContactType(30,"Mobile"));
		addressInitDataWrapperDto.addContactType( new ContactType(40,"Fax"));
		addressInitDataWrapperDto.addContactType( new ContactType(50,"Main"));
		addressInitDataWrapperDto.addContactType( new ContactType(60,"Email"));
		addressInitDataWrapperDto.addContactType( new ContactType(70,"Pager"));
		addressInitDataWrapperDto.addContactType( new ContactType(80,"Other"));
		addressInitDataWrapperDto.addContactType( new ContactType(90,"Web"));
	
		return addressInitDataWrapperDto;
		
	}

	public List<Address> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	

}
