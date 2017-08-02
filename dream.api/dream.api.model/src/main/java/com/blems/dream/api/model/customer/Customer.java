/***
 * @author ngounphanny
 * 
 */
package com.blems.dream.api.model.customer;

import java.util.List;

import com.blems.dream.api.model.DefaultModel;
import com.blems.dream.api.model.account.Account;
import com.blems.dream.api.model.address.Address;
import com.blems.dream.api.model.carrier.Carrier;
import com.blems.dream.api.model.carrier.CarrierService;
import com.blems.dream.api.model.currency.Currency;
import com.blems.dream.api.model.payment.PaymentTerm;
import com.blems.dream.api.model.ship.ShipTerm;
import com.blems.dream.api.model.ui.FilterItemList;

public class Customer extends DefaultModel implements FilterItemList  {
	
	private static final long serialVersionUID = 1L;
	
	private Account account;
	private int carrierServiceId;
	private CarrierService carrierService;
	private Carrier defaultCarrier;
	private PaymentTerm defultPaymentTerm;
	private int defaultSalePersonId;
	private ShipTerm defaultShipTerm;
	private CustomerStatus status;
	private String url;
	private String note;
	private double creditLimit;
	private Currency currency;
	private boolean toBeEmailed;
	private boolean toBePrinted;
	private List<Address> addresses;
	
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}

	public int getCarrierServiceId() {
		return carrierServiceId;
	}
	public void setCarrierServiceId(int carrierServiceId) {
		this.carrierServiceId = carrierServiceId;
	}
	public CarrierService getCarrierService() {
		return carrierService;
	}
	public void setCarrierService(CarrierService carrierService) {
		this.carrierService = carrierService;
	}
	public Carrier getDefaultCarrier() {
		return defaultCarrier;
	}
	public void setDefaultCarrier(Carrier defaultCarrier) {
		this.defaultCarrier = defaultCarrier;
	}
	public PaymentTerm getDefultPaymentTerm() {
		return defultPaymentTerm;
	}
	public void setDefultPaymentTerm(PaymentTerm defultPaymentTerm) {
		this.defultPaymentTerm = defultPaymentTerm;
	}
	public int getDefaultSalePersonId() {
		return defaultSalePersonId;
	}
	public void setDefaultSalePersonId(int defaultSalePersonId) {
		this.defaultSalePersonId = defaultSalePersonId;
	}
	public ShipTerm getDefaultShipTerm() {
		return defaultShipTerm;
	}
	public void setDefaultShipTerm(ShipTerm defaultShipTerm) {
		this.defaultShipTerm = defaultShipTerm;
	}
	
	public CustomerStatus getStatus() {
		return status;
	}
	public void setStatus(CustomerStatus status) {
		this.status = status;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public double getCreditLimit() {
		return creditLimit;
	}
	public void setCreditLimit(double creditLimit) {
		this.creditLimit = creditLimit;
	}
	public Currency getCurrency() {
		return currency;
	}
	public void setCurrency(Currency currency) {
		this.currency = currency;
	}
	public boolean isToBeEmailed() {
		return toBeEmailed;
	}
	public void setToBeEmailed(boolean toBeEmailed) {
		this.toBeEmailed = toBeEmailed;
	}
	public boolean isToBePrinted() {
		return toBePrinted;
	}
	public void setToBePrinted(boolean toBePrinted) {
		this.toBePrinted = toBePrinted;
	}
	public List<Address> getAddresses() {
		return addresses;
	}
	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	public String getAddress(){
		
		String addresss ="N/A";
		
		if(getAddresses()!=null && !getAddresses().isEmpty()){
			addresss= getAddresses().get(0).getFullAddress();
			for (Address address : addresses) {
				if(address.isDefaultFlag()){
					addresss= getAddresses().get(0).getFullAddress();
					break;
				}
			}
		}
		
		
		
		return addresss;
	}
	@Override
	public String getDescription() {
		return null;
	}
	
	
}
