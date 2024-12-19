package com.metinagan.controller;

import com.metinagan.Dto.DtoEmployee;

public interface IRestEmployeeController {

	public DtoEmployee findEmployeeById(Long id);
	
}
