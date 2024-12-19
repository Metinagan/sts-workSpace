package com.metinagan.services.impl;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metinagan.dto.DtoAddress;
import com.metinagan.dto.DtoCustomer;
import com.metinagan.entities.Address;
import com.metinagan.entities.Customer;
import com.metinagan.repository.CustomerRepository;
import com.metinagan.services.ICustomerService;

@Service
public class CustomerServiceImpl implements ICustomerService {

	@Autowired
	private CustomerRepository customerRepository;
	
	@Override
	public DtoCustomer findCustomerById(Long id) {
		
		Optional<Customer> optional = customerRepository.findById(id);
		
		DtoCustomer dtocustomer =new DtoCustomer();
		DtoAddress dtoaddress = new DtoAddress();
		
	
		if(optional.isPresent()) {
			Customer customer = new Customer();
			customer=optional.get();
			Address adress=optional.get().getAddress();
			
			BeanUtils.copyProperties(customer, dtocustomer);
			BeanUtils.copyProperties(adress, dtoaddress);
			dtocustomer.setAddress(dtoaddress);
			return dtocustomer;
		}
		return null;
		
		
	}

}
