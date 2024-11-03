package com.nit.department.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.nit.department.model.Error;

@ControllerAdvice
public class GlobalExceptionAdvice {

	@ExceptionHandler(value = DepartmentNotFoundException.class)
	public ResponseEntity<Error> handleDepartmentNotFoundException(DepartmentNotFoundException ex) {
		Error error = new Error(ex.getMessage(),new Date());
		return new ResponseEntity(error, HttpStatus.NOT_FOUND);
	}
}
