package com.metinagan.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ErrorMessage {
	
	private MessageType messageType;
	private String ofStatic;
	
	public String prepareerrorMessage() {
		StringBuilder builder = new StringBuilder();
		
		if(this.ofStatic!=null) {
			builder.append(" : " + ofStatic);
		}return builder.toString();
	}
}
