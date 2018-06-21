package com.demo.spring;

import com.demo.spring.entity.Emp;

public class EmpService {

	EmpDao dao;
	
	public void setDao(EmpDao dao) {
		this.dao = dao;
	}
	
	public String RegisterEmployee(int id, String name, String city , double salary){
		String resp = dao.save(new Emp(id,name,city,salary));
		return resp;
	}
	
}
