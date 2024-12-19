package com.metinagan.services.impl;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metinagan.dto.DtoAddress;
import com.metinagan.dto.DtoCustomer;
import com.metinagan.entities.Address;
import com.metinagan.repository.AddressRepository;
import com.metinagan.services.IAddressService;

@Service
public class AddressServiceImpl implements IAddressService {

	@Autowired
	private AddressRepository addressrepository;
	
	@Override
	public DtoAddress findAddressById(Long id) {
		
		Optional<Address> optional = addressrepository.findById(id);
		DtoAddress dtoaddress = new DtoAddress();
		
		if(optional.isPresent()) {
			
			Address address = optional.get();
			BeanUtils.copyProperties(address, dtoaddress);
			
			DtoCustomer dtocustomer =new DtoCustomer();
			dtocustomer.setId(address.getCustomer().getId());
			dtocustomer.setName(address.getCustomer().getName());
			
			//açarsak sonsuz döngüye gider zaten adresten customer'a gidiyoruz
			//dtocustomer.setAddress(dtoaddress);
			
			dtoaddress.setCustomer(dtocustomer);
			return dtoaddress;
		}
		return null;
	}
}
