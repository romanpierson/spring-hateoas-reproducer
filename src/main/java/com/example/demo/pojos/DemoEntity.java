package com.example.demo.pojos;

import org.springframework.hateoas.RepresentationModel;

public class DemoEntity extends RepresentationModel<DemoEntity> {

	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	
	
	
	
}
