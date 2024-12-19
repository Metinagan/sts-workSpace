package com.metinagan.service.impl;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metinagan.Dto.DtoDepartment;
import com.metinagan.Dto.DtoEmployee;
import com.metinagan.jwt.AuthResponse;
import com.metinagan.model.Department;
import com.metinagan.model.Employee;
import com.metinagan.repository.EmployeeRepository;
import com.metinagan.service.IEmployeeService;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	
	@Override
	public DtoEmployee findEmployeeById(Long id) {
		Optional<Employee> optional = employeeRepository.findById(id);
		if(optional.isEmpty()) {
			return null;
		}
		
		Employee employee =optional.get();
		Department department = employee.getDepartment();
		
		DtoEmployee dtoEmployee =new DtoEmployee();
		DtoDepartment dtoDepartment = new DtoDepartment();
		
		BeanUtils.copyProperties(employee, dtoEmployee);
		BeanUtils.copyProperties(department, dtoDepartment);
		
		dtoEmployee.setDepartment(dtoDepartment);
		
		return dtoEmployee;
	}


	

}








