package com.metinagan.utils;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;

import lombok.experimental.UtilityClass;

@UtilityClass
public class PagerUtil {
	
	public boolean isNullorEmptty(String value) {
		return value==null||value.trim().length()==0;
	}
	
	public PageRequest toPageable(RestPageableRequest request) {
		
		if(isNullorEmptty(request.getColumnName())) {
			Sort sortBy = request.isAsc() ? Sort.by(Direction.ASC,request.getColumnName())
										  : Sort.by(Direction.DESC,request.getColumnName());
			
			return PageRequest.of(request.getPageNumber(), request.getPageSize(), sortBy);
		}else {
			return PageRequest.of(request.getPageNumber(), request.getPageSize());
		}
	}
	
	
}
