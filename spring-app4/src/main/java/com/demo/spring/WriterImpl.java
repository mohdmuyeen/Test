package com.demo.spring;

import org.springframework.stereotype.Repository;

@Repository
public class WriterImpl implements Writer {

	@Override
	public String write(String s) {
		
		return "Message :" + s ;
	}

}
