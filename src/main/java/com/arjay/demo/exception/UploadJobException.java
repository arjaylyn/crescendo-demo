package com.arjay.demo.exception;

public class UploadJobException extends RuntimeException {

	public UploadJobException(String message) {
		super(message);
	}

	public UploadJobException(String message, Throwable cause) {
		super(message, cause);
	}
}