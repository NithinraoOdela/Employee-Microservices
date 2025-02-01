package com.company.employees.exception;

public class ResourceNotFoundExceptionHandler extends RuntimeException {

	public ResourceNotFoundExceptionHandler() {
		super("Resource Not found !!");
	}

	public ResourceNotFoundExceptionHandler(String message) {
		super(message);
	}
}
