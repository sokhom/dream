/***
 * @author ngounphanny
 * 
 */
package com.blems.dream.api.model.address;

import java.util.ArrayList;
import java.util.List;

import com.blems.dream.api.model.BasedModel;
import com.blems.dream.api.model.account.Account;
import com.blems.dream.api.model.contact.Contact;

public class Address extends BasedModel {

	private static final long serialVersionUID = 1L;
	private Account account;
	private String name;
	private Country country;
	private State state;
	private String city;
	private String address;
	private String zip;
	private AddressType type;
	private int locationGroupId;
	private boolean defaultFlag;
	private boolean residentialFlag;
	private List<Contact> contacts;
	
	
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Country getCountry() {
		return country;
	}
	public void setCountry(Country country) {
		this.country = country;
	}
	public State getState() {
		return state;
	}
	public void setState(State state) {
		this.state = state;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public AddressType getType() {
		return type;
	}
	public void setType(AddressType type) {
		this.type = type;
	}
	public int getLocationGroupId() {
		return locationGroupId;
	}
	public void setLocationGroupId(int locationGroupId) {
		this.locationGroupId = locationGroupId;
	}
	public boolean isDefaultFlag() {
		return defaultFlag;
	}
	public void setDefaultFlag(boolean defaultFlag) {
		this.defaultFlag = defaultFlag;
	}
	public boolean isResidentialFlag() {
		return residentialFlag;
	}
	public void setResidentialFlag(boolean residentialFlag) {
		this.residentialFlag = residentialFlag;
	}
	
	public List<Contact> getContacts() {
		if(contacts ==null) {
			contacts =new ArrayList<>();
		}
		return contacts;
	}
	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}
	public String getFullAddress(){
		return String.format("%s, %s, %s", getAddress(), getCity(), getCountry().getName());
	}
	
	@Override
	public String toString() {
		return getName();
	}
	
	
	
}
