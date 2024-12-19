package com.metinagan.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.metinagan.Dto.DtoEmployee;
import com.metinagan.controller.IRestEmployeeController;
import com.metinagan.service.IEmployeeService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;

@RestController
@RequestMapping("/employee")
public class RestEmployeeControllerImpl implements IRestEmployeeController {

	@Autowired
	private IEmployeeService employeeService;
	
	@GetMapping("/list/{id}")
	@Override
	public DtoEmployee findEmployeeById(@PathVariable(value = "id") Long id) {
		return employeeService.findEmployeeById(id);
	}

}
