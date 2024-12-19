package com.metinagan.service;

import com.metinagan.Dto.DtoEmployee;
import com.metinagan.jwt.AuthResponse;

public interface IEmployeeService {

	public DtoEmployee findEmployeeById(Long id);
	
	
	
}
