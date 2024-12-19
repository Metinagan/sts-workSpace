package com.metinagan.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metinagan.dto.DtoDepartmant;
import com.metinagan.dto.DtoEmployee;
import com.metinagan.entities.Employee;
import com.metinagan.repository.EmployeeRepository;
import com.metinagan.services.IEmployeeService;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

	@Autowired
	private EmployeeRepository employeerepository;
	
	@Override
	public List<DtoEmployee> findAllEmployee() {
		
		List<Employee> emplist = employeerepository.findAll();
		
		if(!emplist.isEmpty() && emplist!=null) {
			List<DtoEmployee> dtoemployeelist =new ArrayList<>();
			
			for (Employee employee : emplist) {
				DtoEmployee dtoemployee =new DtoEmployee();
				BeanUtils.copyProperties(employee, dtoemployee);
				DtoDepartmant dtodepartment=new DtoDepartmant();
				BeanUtils.copyProperties(employee.getDepartment(), dtodepartment);
				dtoemployee.setDepartmant(dtodepartment);
				
				dtoemployeelist.add(dtoemployee);
			}
			return dtoemployeelist;
		}
		return null;
	}

}























