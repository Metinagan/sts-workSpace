package com.metinagan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.metinagan.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
