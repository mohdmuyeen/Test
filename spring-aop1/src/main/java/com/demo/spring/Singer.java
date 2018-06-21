package com.demo.spring;

import org.springframework.stereotype.Service;

@Service
public class Singer implements Performer {

	@Override
	public void perform() {
		// TODO Auto-generated method stub
		System.out.println("Singer singing : hello");
	}

}
