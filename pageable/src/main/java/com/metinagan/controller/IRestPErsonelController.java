package com.metinagan.controller;

import org.springframework.data.domain.Page;

import com.metinagan.utils.RestPageableRequest;

import model.Personel;

public interface IRestPErsonelController {

	public Page<Personel> findAllPageable(RestPageableRequest PageableRequest);

	
	
}
