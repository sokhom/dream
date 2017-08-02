package com.belms.dream.repositories.employee;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.belms.dream.repositories.employee.persistence.EmployeeMapper;

public class Test {
	
	public static void main(String[] args) {
		EmployeeRepo employeeRepo = new EmployeeRepo();
		
		SqlSession session = null;
		try{
			session =employeeRepo.getSessionFactory().openSession();
			EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);
			List<City> cities= employeeMapper.selectAll();
			for (City city : cities) {
				System.out.println(city.getName());
			}
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.clearCache();
		}
		
		
	}
}
