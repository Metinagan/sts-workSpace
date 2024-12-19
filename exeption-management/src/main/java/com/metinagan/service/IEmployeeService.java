package com.metinagan.service;

import com.metinagan.dto.DtoEmployee;


public interface IEmployeeService {

	public DtoEmployee findEmployeeById(Long id);
	
}
