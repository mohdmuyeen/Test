package com.demo.spring;

import com.demo.spring.entity.Emp;

public class EmpDaoJPAImpl implements EmpDao {

	@Override
	public String save(Emp e) {
		// TODO Auto-generated method stub
		return "JPA :Emp saved with ID " + e.getEmpId(); 
	}

}
