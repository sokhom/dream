/***
 * @author ngounphanny
 * 
 */
package com.belms.dream.service.employee;

import java.util.List;

import com.belms.dream.repositories.employee.City;
import com.belms.dream.repositories.employee.EmployeeRepo;

public class EmployeeServiceImpl implements EmployeeService {

	public City add(City t) {
		return null;
	}

	public void remove(City t) {

		
	}

	public City edit(City t) {

		return null;
	}

	public List<City> getAll() {
		EmployeeRepo employeeRepo = new EmployeeRepo();
		return employeeRepo.selectAll();
	}

	public City getById(int Id) {

		return null;
	}



	

}
