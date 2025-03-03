package com.metinagan.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DtoPersonel {

	private Long id;
	
	private String firstname;
	
	private String lastname;
	
	private DtoDepartment department;
	
}
