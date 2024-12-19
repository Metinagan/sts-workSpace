package com.metinagan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.metinagan.entities.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{

}
