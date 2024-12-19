package com.metinagan.exception;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	private List<String> addMapValue(List<String> list,String newValue){
		list.add(newValue);
		return list;
	}
	//Spring validationdan fırlatılan hataları yakalayıp
	//okunaklı olarak response dönmek
	
	@ExceptionHandler(value = MethodArgumentNotValidException.class)
	public ResponseEntity<ApiError> handleMethodargumentNotValidException(MethodArgumentNotValidException exception) {
		List<ObjectError> errorList=exception.getBindingResult().getAllErrors();
		
		Map<String, List<String>> errorsMap = new HashMap<>();
		
		for (ObjectError objectError : errorList) {
			//hata fırlatılan değişkenin ismini alıyoruz.
			String fieldName = ((FieldError)objectError).getField();
			//filedName mimiz map in içerisined daha önce den eklenmişmi
			if(errorsMap.containsKey(fieldName)) {
				errorsMap.put(fieldName, addMapValue(errorsMap.get(fieldName), objectError.getDefaultMessage()));
			}else {
				errorsMap.put(fieldName, addMapValue(new ArrayList<>(), objectError.getDefaultMessage()));
			}
		}
		return ResponseEntity.badRequest().body(creaApiError(errorsMap));
	}
	
	
	private <T> ApiError<T> creaApiError(T errors) {
		ApiError<T> apiError = new ApiError<T>();
		apiError.setId(UUID.randomUUID().toString());
		apiError.setErrorTime(new Date());
		apiError.setErrors(errors);
		
		 return apiError;
	}
	
	
	
	
	
	
	
	
	
	
}
