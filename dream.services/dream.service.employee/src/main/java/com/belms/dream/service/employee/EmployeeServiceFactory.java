/***
 * @author ngounphanny
 * 
 */
package com.belms.dream.service.employee;

import com.belms.dream.api.service.Service;
import com.belms.dream.api.service.ServiceFactory;
import com.blems.dream.api.model.Employee;

public class EmployeeServiceFactory implements ServiceFactory {
	
	private static final String EMPOYEE_SERIVCE = "EMPOYEE_SERIVCE";

	public String getId() {
		return EMPOYEE_SERIVCE;
	}
	
	public Service<Employee> getService() {
		// TODO Auto-generated method stub
		return null;
	}

}
