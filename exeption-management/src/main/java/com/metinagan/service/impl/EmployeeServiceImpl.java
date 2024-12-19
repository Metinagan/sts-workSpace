package com.metinagan.service.impl;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metinagan.dto.DtoDepartment;
import com.metinagan.dto.DtoEmployee;
import com.metinagan.exepcition.BaseException;
import com.metinagan.exepcition.ErrorMessage;
import com.metinagan.exepcition.MessageType;
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

		DtoEmployee dtoemployee = new DtoEmployee();
		DtoDepartment dtodepartment = new DtoDepartment();

		Optional<Employee> optional = employeeRepository.findById(id);

		if (optional.isEmpty()) {
			throw new BaseException(new ErrorMessage(MessageType.NO_RECORD_EXIST,id.toString()));
		}
		Employee employee = optional.get();
		Department department = employee.getDepartment();

		BeanUtils.copyProperties(employee, dtoemployee);
		BeanUtils.copyProperties(department, dtodepartment);

		dtoemployee.setDepartment(dtodepartment);

		return dtoemployee;
	}

}
