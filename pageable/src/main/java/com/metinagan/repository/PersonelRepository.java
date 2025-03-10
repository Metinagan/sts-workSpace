package com.metinagan.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import model.Personel;

@Repository
public interface PersonelRepository extends JpaRepository<Personel, Long> {

	@Query(value = "from Personel")
	Page<Personel> findAllPageable(Pageable pagable);
}
