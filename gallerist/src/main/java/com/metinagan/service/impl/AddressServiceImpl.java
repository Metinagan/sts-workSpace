package com.metinagan.service.impl;

import org.springframework.stereotype.Service;
import com.metinagan.exception.BaseException;
import com.metinagan.exception.ErrorMessage;
import com.metinagan.exception.MessageType;
import com.metinagan.service.IAddressService;

@Service
public class AddressServiceImpl implements IAddressService {

	@Override
	public void test() {
		throw new BaseException(new ErrorMessage(MessageType.NO_RECORD_EXIST,null));
	}

	
	
}
