package com.metinagan.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.metinagan.model.User;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	
	Optional<User>findByUsername(String username);
	
}
