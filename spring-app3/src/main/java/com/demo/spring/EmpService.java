package com.demo.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.demo.spring.entity.Emp;
@Service
public class EmpService {

	@Autowired
	@Qualifier("jpa")
	EmpDao dao;
	/*
	public void setDao(EmpDao dao) {
		this.dao = dao;
	}
	*/
	public String RegisterEmployee(int id, String name, String city , double salary){
		String resp = dao.save(new Emp(id,name,city,salary));
		return resp;
	}
	
}
