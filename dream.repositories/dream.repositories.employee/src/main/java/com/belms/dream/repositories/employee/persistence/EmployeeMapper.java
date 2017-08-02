package com.belms.dream.repositories.employee.persistence;

import java.util.List;

import com.belms.dream.repositories.employee.City;

public interface EmployeeMapper {
	List<City> selectAll();
}
