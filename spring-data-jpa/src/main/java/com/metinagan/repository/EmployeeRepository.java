package com.metinagan.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.metinagan.entities.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
