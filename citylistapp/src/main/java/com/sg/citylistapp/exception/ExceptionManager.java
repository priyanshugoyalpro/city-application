package com.sg.citylistapp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author priyanshu.goyal
 *
 */
@ControllerAdvice
public class ExceptionManager {

	@ExceptionHandler(CityNotFoundException.class)
	public ResponseEntity<Object> CityNotFoundException(CityNotFoundException exception) {
		return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);

	}
}
