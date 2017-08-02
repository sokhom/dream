/***
 * @author ngounphanny
 * 
 */
package com.belms.dream.api.dto.address;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.blems.dream.api.model.address.AddressType;
import com.blems.dream.api.model.address.Country;
import com.blems.dream.api.model.address.State;
import com.blems.dream.api.model.contact.ContactType;

public class AddressInitDataWrapperDto implements Serializable{

	private static final long serialVersionUID = 1L;
	private List<AddressType> addressTypes;
	private List<Country> countries;
	private List<State> states;
	private List<ContactType> contactTypes;
	
	public void addAddressType(AddressType addressType){
		if(addressTypes == null ){
			addressTypes = new ArrayList<>();
		}
		addressTypes.add(addressType);
	}
	
	public void addCountry(Country country){
		if(countries == null ){
			countries = new ArrayList<>();
		}
		
		countries.add(country);
	}
	
	public void addState(State state) {
		if(states==null){
			states = new ArrayList<>();
		}
		states.add(state);
	}
	
	
	public void addContactType(ContactType contactType){
		if(contactTypes==null){
			contactTypes = new ArrayList<>();
		}
		
		contactTypes.add(contactType);
	}
	
	public List<AddressType> getAddressTypes() {
		return addressTypes;
	}
	public void setAddressTypes(List<AddressType> addressTypes) {
		this.addressTypes = addressTypes;
	}
	public List<Country> getCountries() {
		return countries;
	}
	public void setCountries(List<Country> countries) {
		this.countries = countries;
	}
	public List<State> getStates() {
		return states;
	}
	public void setStates(List<State> states) {
		this.states = states;
	}

	public List<ContactType> getContactTypes() {
		return contactTypes;
	}

	public void setContactTypes(List<ContactType> contactTypes) {
		this.contactTypes = contactTypes;
	}
	
	

}
