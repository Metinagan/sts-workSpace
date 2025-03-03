package com.metinagan.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.metinagan.controller.IRestPErsonelController;
import com.metinagan.service.IPersonelService;
import com.metinagan.utils.RestPageableRequest;

import model.Personel;

@RestController
@RequestMapping("/rest/api/personel")
public class RestPersonelControllerImpl extends RestBaseController implements IRestPErsonelController {

	@Autowired
	private IPersonelService personelService;
	
	@GetMapping("list/pageable")
	@Override
	public Page<Personel> findAllPageable(RestPageableRequest pageableRequest) {
		
		return personelService.findAllPAgeable(toPAgeable(pageableRequest));
	}
	
	
	
	
}
