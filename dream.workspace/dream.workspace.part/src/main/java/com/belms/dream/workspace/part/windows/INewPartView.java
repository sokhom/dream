/***
 * @author ngounphanny
 * 
 */
package com.belms.dream.workspace.part.windows;

import com.belms.dream.api.view.event.AddnewEntityListener;
import com.blems.dream.api.model.customer.Customer;
import com.blems.dream.api.model.part.Part;

public interface INewPartView {
	
	void setAddNewListener(AddnewEntityListener<Part> addNewPartListener);
	
}
