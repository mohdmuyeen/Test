package com.demo.day2.spring;

import java.util.List;

import com.demo.day2.spring.entity.Emp;

public interface EmpDao {

	public String save(Emp e);

	public String delete(int empId);

	public Emp findById(int id);

	public List<Emp> getAll();

	public String saveSome(List<Emp> emps);
}