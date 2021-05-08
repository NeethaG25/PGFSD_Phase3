package com.simplilearn.neetha.gateway;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;

public class SportyShoesGateway<T> {
	
	private Boolean status;
	private HttpStatus httpStatus;
	private String message;
	private T result;
	private List<String> errors;
	private List<FieldError> fieldErrors;

	public SportyShoesGateway() {
		super();
	}

	public SportyShoesGateway(Boolean status, final HttpStatus httpStatus, final T result) {
		super();
		this.status = status;
		this.httpStatus = httpStatus;
		this.result = result;
	}

	public SportyShoesGateway(Boolean status, final HttpStatus httpStatus, final String message, final List<String> errors) {
		super();
		this.status = status;
		this.httpStatus = httpStatus;
		this.message = message;
		this.errors = errors;
	}

	public SportyShoesGateway(String message, final List<String> errors) {
		super();
		this.status = false;
		this.httpStatus = HttpStatus.BAD_REQUEST;
		this.message = message;
		this.errors = errors;

	}

	public SportyShoesGateway(Boolean status, final HttpStatus httpStatus, final String message, final String error) {
		super();
		this.status = status;
		this.httpStatus = httpStatus;
		this.message = message;
		if (!StringUtils.isEmpty(error)) {
			errors = Arrays.asList(error);
		}

	}

	public SportyShoesGateway(final HttpStatus httpStatus, final String message) {
		super();
		this.status = Boolean.FALSE;
		this.httpStatus = httpStatus;
		this.message = message;

	}

	public SportyShoesGateway(final HttpStatus httpStatus, final T result, final String message) {
		super();
		this.httpStatus = httpStatus;
		this.message = message;
		this.result = result;
	}

	public SportyShoesGateway(Boolean status, final HttpStatus httpStatus, final String message, final T result) {
		super();
		this.status = status;
		this.httpStatus = httpStatus;
		this.message = message;
		this.result = result;
	}

	public SportyShoesGateway(Boolean status, final HttpStatus httpStatus, final List<String> errors) {
		super();
		this.status = status;
		this.httpStatus = httpStatus;
		this.message = errors.toString();
		this.errors = errors;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getResult() {
		return result;
	}

	public void setResult(T result) {
		this.result = result;
	}

	public List<String> getErrors() {
		return errors;
	}

	public void setErrors(List<String> errors) {
		this.errors = errors;
	}

	public List<FieldError> getFieldErrors() {
		return fieldErrors;
	}

	public void setFieldErrors(List<FieldError> fieldErrors) {
		this.fieldErrors = fieldErrors;
	}


}
