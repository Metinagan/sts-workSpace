package com.metinagan.controller;

import com.metinagan.dto.DtoCustomer;

public interface ICustomerController {

	public DtoCustomer findCustomerById(Long id);
	
}
