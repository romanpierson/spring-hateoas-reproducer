package com.example.demo.controller;

import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.pojos.DemoEntity;

@RestController
//@RequestMapping(value = "/demo") // Using this works as expected
@RequestMapping(value = "/${basePath}")
public class DemoController {

	@GetMapping("/{demoId}")
    public DemoEntity getDemoById(@PathVariable String demoId) {
        
		DemoEntity demo = new DemoEntity();
		demo.setId(demoId);
		
		demo.add(WebMvcLinkBuilder.linkTo(DemoController.class).slash(demoId).withSelfRel());
		
		return demo;
    }
	
}
