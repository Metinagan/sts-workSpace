package com.metinagan.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.metinagan.controller.ICustomerController;
import com.metinagan.dto.DtoCustomer;
import com.metinagan.services.ICustomerService;

@RestController
@RequestMapping("rest/api/customer")
public class CustomerContollerImpl implements ICustomerController {

	@Autowired
	private ICustomerService customerService; 
	
	@GetMapping(path = "/list/{id}")
	@Override
	public DtoCustomer findCustomerById(@PathVariable(name = "id") Long id) {
		return customerService.findCustomerById(id);
	}

}
