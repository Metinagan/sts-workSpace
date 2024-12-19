package com.metinagan.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(value = Include.NON_NULL)//null  değer varsa geriye o değeri döndermiyor
public class DtoAddress {

	private Long id;
	
	private String description;	
	
	private DtoCustomer customer;
}
