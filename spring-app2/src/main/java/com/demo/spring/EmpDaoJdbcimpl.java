package com.demo.spring;

import com.demo.spring.entity.Emp;

public class EmpDaoJdbcimpl implements EmpDao {

	@Override
	public String save(Emp e) {
		// TODO Auto-generated method stub
		return "JDBC :Emp saved with ID " + e.getEmpId(); 
	}

}
