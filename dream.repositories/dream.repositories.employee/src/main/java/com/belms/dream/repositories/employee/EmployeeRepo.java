package com.belms.dream.repositories.employee;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.belms.dream.repositories.employee.persistence.EmployeeMapper;

public class EmployeeRepo {
	private String resource = "D:/dev/Java/config/repositories/employee/persistence/configuration.xml";
	private SqlSessionFactory sessionFactory;

	public SqlSessionFactory getSessionFactory() {

		
		if (sessionFactory == null) {
			
			try {
				
				FileReader fileReader = new FileReader(resource);
				sessionFactory = new SqlSessionFactoryBuilder().build(fileReader);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return sessionFactory;
	}

	public List<City> selectAll() {
		SqlSession session = null;
		try {
			session = getSessionFactory().openSession();
			EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);
			List<City> cities = employeeMapper.selectAll();
			return cities;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.clearCache();
		}
		return null;
	}

}
