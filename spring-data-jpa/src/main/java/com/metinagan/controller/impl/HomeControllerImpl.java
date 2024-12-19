package com.metinagan.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.metinagan.controller.IHomeController;
import com.metinagan.dto.DtoHome;
import com.metinagan.services.IHomeService;

@RestController
@RequestMapping("rest/api/home")
public class HomeControllerImpl implements IHomeController {

	@Autowired
	private IHomeService homeservice;
	
	@Override
	@GetMapping(path = "/list/{id}")
	public DtoHome findhomeById(@PathVariable(name = "id" ) Long id) {
		
		return homeservice.findHomeById(id);
	}

	
	
}
