package com.demo.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class Write  {

	@Autowired
	
	Writer write;

	public void print(String s){
		System.out.println(write.write(s));
	}
}
