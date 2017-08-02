/***
 * @author ngounphanny
 * 
 */
package com.belms.dream.api.dto.customer;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.blems.dream.api.model.carrier.Carrier;
import com.blems.dream.api.model.carrier.CarrierService;
import com.blems.dream.api.model.currency.Currency;
import com.blems.dream.api.model.customer.CustomerStatus;
import com.blems.dream.api.model.payment.PaymentTerm;
import com.blems.dream.api.model.ship.ShipTerm;

public class CustomerInitDataWrapperDto implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private List<Currency> currencies;
	private List<CustomerStatus> statusList;
	private List<PaymentTerm> paymentTerms;
	private List<ShipTerm> shipTerms;
	List<Carrier> carriers;
	List<CarrierService> carrierServices;
	
	public void addCurrency(Currency currency) {
		if(currencies ==null){
			currencies = new ArrayList<>();
		}
		
		currencies.add(currency);
	}
	
	
	public void addStatus(CustomerStatus customerStatus){
		if(statusList == null){
			statusList = new ArrayList<>();
		}
		
		statusList.add(customerStatus);
	}
	
	
	public void addPaymentTerm(PaymentTerm paymentTerm){
		if(paymentTerms==null){
			paymentTerms = new ArrayList<>();
		}
		paymentTerms.add(paymentTerm);
	}
	
	public void addShipTerm(ShipTerm shipTerm){
		if(shipTerms == null){
			shipTerms =new ArrayList<>();
		}
		
		shipTerms.add(shipTerm);
	}
	
	public void addCarrier(Carrier carrier){
		if(carriers == null){
			carriers = new ArrayList<>();
		}
		
		carriers.add(carrier);
	}
	
	public void addCarrierService(CarrierService carrierService){
		if(carrierServices == null){
			carrierServices = new ArrayList<>();
		}
		carrierServices.add(carrierService);
	}
	
	public List<Currency> getCurrencies() {
		return currencies;
	}
	public void setCurrencies(List<Currency> currencies) {
		this.currencies = currencies;
	}
	public List<CustomerStatus> getStatusList() {
		return statusList;
	}
	public void setStatusList(List<CustomerStatus> statusList) {
		this.statusList = statusList;
	}


	public List<PaymentTerm> getPaymentTerms() {
		return paymentTerms;
	}


	public void setPaymentTerms(List<PaymentTerm> paymentTerms) {
		this.paymentTerms = paymentTerms;
	}


	public List<ShipTerm> getShipTerms() {
		return shipTerms;
	}


	public void setShipTerms(List<ShipTerm> shipTerms) {
		this.shipTerms = shipTerms;
	}


	public List<Carrier> getCarriers() {
		return carriers;
	}


	public void setCarriers(List<Carrier> carriers) {
		this.carriers = carriers;
	}


	public List<CarrierService> getCarrierServices() {
		return carrierServices;
	}


	public void setCarrierServices(List<CarrierService> carrierServices) {
		this.carrierServices = carrierServices;
	}
	
	
	
	
}
