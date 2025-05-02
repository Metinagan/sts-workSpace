package com.metinagan.exception;

import lombok.Getter;

@Getter
public enum MessageType {

	NO_RECORD_EXIST("1004","Kayıt Bulunamadı"),
	GENERAL_EXCEPTİON("9999","Genel  bir Hata Oluştu");
	
	private String code;
	
	private String message;
	
	MessageType(String code,String message){
		this.code = code;
		this.message = message;
	}
}
