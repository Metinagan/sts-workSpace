package com.metinagan.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.metinagan.controller.IEmployeeContoller;
import com.metinagan.dto.DtoEmployee;
import com.metinagan.services.IEmployeeService;

@RestController
@RequestMapping(path = "rest/api/employee")
public class EmployeeControllerImpl implements IEmployeeContoller {

	@Autowired
	private IEmployeeService employeeService;
	
	@Override
	@GetMapping(path = "/list")
	public List<DtoEmployee> findAllEmployee() {
		return employeeService.findAllEmployee();
	}

}
