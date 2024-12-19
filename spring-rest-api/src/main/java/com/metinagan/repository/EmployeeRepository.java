package com.metinagan.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.metinagan.model.Employee;
import com.metinagan.model.updateEmployeeRequest;

@Repository
public class EmployeeRepository {

	@Autowired 	 
	private List<Employee> employeeList;
	
	
	public List<Employee> getAllEmployeeList(){
		
		return employeeList;
	}
	
	public Employee getEmployeeById(String id) {
		Employee employeeById=null;
		
		for(Employee employee:employeeList) {
			if(id.equals(employee.getId())) {
				employeeById=employee;
				break;
			}
		}
		return employeeById;
	}
	
	public List<Employee> getEmployeeWithParams(String firstName,String lastName){
		List<Employee> employeeWithParams=new ArrayList<>();
		
		if(firstName==null && lastName==null) {
			return employeeList;
		}
		else {
			for (Employee employee : employeeList) {
				
				if(firstName!=null && lastName !=null) {
					if (employee.getFirstName().equalsIgnoreCase(firstName) && 
						employee.getLastName().equalsIgnoreCase(lastName)) {
						employeeWithParams.add(employee);
					}
				}
				if(firstName==null && lastName!= null) {
					if(employee.getLastName().equalsIgnoreCase(lastName)) {
						employeeWithParams.add(employee);
					}
				}
				if (firstName!=null && lastName==null){
					if(employee.getLastName().equalsIgnoreCase(firstName)) {
						employeeWithParams.add(employee);
					}
				}
			}
		}
		return employeeWithParams;
	}
	
	public Employee saveEmployee(Employee newEmployee) {
		
		employeeList.add(newEmployee);
		return newEmployee;
	}
	
	public boolean deleteEmployee(String id) {
		Employee deleteEmployee=null;
		
		for (Employee employee : employeeList) {
			if(id.equals(employee.getId())) {
				deleteEmployee=employee;
				break;
			}
		}
		if(deleteEmployee==null) {
			return false;
		}
		employeeList.remove(deleteEmployee);
		return true;
	}

	public Employee findByEmployee(String id) {
		Employee findingEmployee=null;
		for (Employee employee : employeeList) {
			if (id.equals(employee.getId())) {
				findingEmployee=employee;
				break;
			}
		}
		return findingEmployee;
	}
	
	public Employee updateEmployee(String id,updateEmployeeRequest request) {
		
		Employee requestEmployee=null;
		
		for (Employee employee : employeeList) {
			if (id.equals(employee.getId())) {
				employee.setFirstName(request.getFirstName());
				employee.setLastName(request.getLastName());
				requestEmployee=employee;
				break;
			}
		}
		return requestEmployee;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
