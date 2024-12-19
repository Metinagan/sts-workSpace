package com.metinagan.exepcition;

public class BaseException extends RuntimeException {

	public BaseException() {

	}

	public BaseException(ErrorMessage errorMesage) {
		super(errorMesage.prepareErrorMessage());
	}
}
