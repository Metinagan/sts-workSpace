package com.metinagan.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.metinagan.controller.IEmployeecontroller;
import com.metinagan.dto.DtoEmployee;
import com.metinagan.model.RootEntity;
import com.metinagan.service.IEmployeeService;

@RestController
@RequestMapping("rest/api/employee")
public class EmployeeControllerImpl extends RestBaseController implements IEmployeecontroller {

	@Autowired
	private IEmployeeService employeeService;

	@Override
	@GetMapping(path = "/list/{id}")
	public RootEntity<DtoEmployee> findEmployeeById(@PathVariable(name = "id") Long id) {
		return ok(employeeService.findEmployeeById(id));
	}

}
