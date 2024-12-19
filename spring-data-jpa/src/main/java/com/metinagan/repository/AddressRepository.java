package com.metinagan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.metinagan.entities.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

}
