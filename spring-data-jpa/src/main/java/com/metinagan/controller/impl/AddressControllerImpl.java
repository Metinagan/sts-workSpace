package com.metinagan.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.metinagan.controller.IAddressController;
import com.metinagan.dto.DtoAddress;
import com.metinagan.services.IAddressService;


@RestController
@RequestMapping("rest/api/address")
public class AddressControllerImpl implements IAddressController {
	
	@Autowired
	private IAddressService addressservice;

	@Override
	@GetMapping(path = "/list/{id}")
	public DtoAddress findAddressById(@PathVariable(name = "id") Long id) {
		return addressservice.findAddressById(id);
	}

	
	
	
}
