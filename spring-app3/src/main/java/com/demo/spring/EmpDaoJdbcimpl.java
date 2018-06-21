package com.demo.spring;

import org.springframework.stereotype.Repository;

import com.demo.spring.entity.Emp;

@Repository
public class EmpDaoJdbcimpl implements EmpDao {

	@Override
	public String save(Emp e) {
		// TODO Auto-generated method stub
		return "JDBC :Emp saved with ID " + e.getEmpId(); 
	}

}
