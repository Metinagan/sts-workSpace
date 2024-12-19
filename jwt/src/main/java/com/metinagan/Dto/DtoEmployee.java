package com.metinagan.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

 @Getter
 @Setter
 @NoArgsConstructor
 @AllArgsConstructor
public class DtoEmployee {


	private String firstName;
	
	private String lastName;
	
	private DtoDepartment department;
	
}
