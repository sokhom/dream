/***
 * @author ngounphanny
 * 
 */
package com.belms.dream.workspace.customer;

import com.belms.dream.api.view.event.AddnewEntityListener;
import com.blems.dream.api.model.customer.Customer;

public interface NewCustomerView {
	void setAddNewListener(AddnewEntityListener<Customer> addNewCustomerListener);

}
