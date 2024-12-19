package com.metinagan.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.metinagan.model.Employee;

@Configuration
public class AppConfig {
	
	@Bean
	public List<Employee> employeeList(){
		
		List<Employee> employeeList=new ArrayList<>();
		
		employeeList.add(new Employee("1","Enes" ,"Bayram"));
		employeeList.add(new Employee("2","Metin","Ağan"  ));
		employeeList.add(new Employee("3","Kaan" ,"Hançer"));
		employeeList.add(new Employee("4","Ali"  ,"Bunsuz"));
		employeeList.add(new Employee("5","Ensar","Çiçek" ));
		
		return employeeList;
	}
}
