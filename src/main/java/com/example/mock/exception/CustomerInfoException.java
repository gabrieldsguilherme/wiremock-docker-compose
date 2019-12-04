package com.example.mock.exception;

public class CustomerInfoException extends RuntimeException {

	private static final long serialVersionUID = 7407928197844407408L;
	
	public CustomerInfoException(Throwable e) {
		super("Error retrieving customer information.", e);
	}

}
