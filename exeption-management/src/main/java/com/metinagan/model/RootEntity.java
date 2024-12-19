package com.metinagan.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RootEntity<T> {

	private Boolean result;

	private String errorMesage;

	private T data;

	public static <T> RootEntity<T> ok(T data) {
		RootEntity<T> rootEntity = new RootEntity<>();
		rootEntity.setData(data);
		rootEntity.setErrorMesage(null);
		rootEntity.setResult(true);
		return rootEntity;
	}

	public static <T> RootEntity<T> error(String errorMessage) {
		RootEntity<T> rootEntity = new RootEntity<>();
		rootEntity.setData(null);
		rootEntity.setErrorMesage(errorMessage);
		rootEntity.setResult(false);
		return rootEntity;
	}
}






