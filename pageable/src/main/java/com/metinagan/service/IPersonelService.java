package com.metinagan.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import model.Personel;

public interface IPersonelService {

	Page<Personel> findAllPAgeable(Pageable pageable);
}
