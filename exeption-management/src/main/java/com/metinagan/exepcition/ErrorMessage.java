package com.metinagan.exepcition;

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

	private String ofstatic;

	public String prepareErrorMessage() {
		StringBuilder builder = new StringBuilder();
		builder.append(messageType.getMessage());
		if (ofstatic != null) {
			builder.append(" : " + ofstatic);
		}
		return builder.toString();

	}

}
