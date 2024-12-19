package com.metinagan.services;

import com.metinagan.dto.DtoCustomer;

public interface ICustomerService {

	public DtoCustomer findCustomerById(Long id);
}
