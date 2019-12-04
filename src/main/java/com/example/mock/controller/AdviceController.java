package com.example.mock.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.mock.exception.CustomerInfoException;

import com.example.mock.json.Error;

@ControllerAdvice
public class AdviceController {
	
	@ExceptionHandler(CustomerInfoException.class)
	public ResponseEntity<Error> handleCustomerInfoException(CustomerInfoException e) {
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new Error(e.getMessage()));
	}

}
