package com.demo.spring;

import org.springframework.stereotype.Repository;

import com.demo.spring.entity.Emp;

@Repository("jpa")
public class EmpDaoJPAImpl implements EmpDao {

	@Override
	public String save(Emp e) {
		// TODO Auto-generated method stub
		return "JPA :Emp saved with ID " + e.getEmpId(); 
	}

}
