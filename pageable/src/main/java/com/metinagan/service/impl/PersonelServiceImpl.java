package com.metinagan.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.metinagan.repository.PersonelRepository;
import com.metinagan.service.IPersonelService;
import model.Personel;

@Service
public class PersonelServiceImpl implements IPersonelService {

	@Autowired
	private PersonelRepository personelRepository;
	
	@Override
	public Page<Personel> findAllPAgeable(Pageable pageable) {
		
		Page<Personel> page = personelRepository.findAllPageable(pageable);
		return page;
	}

	
	
}
