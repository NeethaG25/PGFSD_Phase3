package com.simplilearn.neetha.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.simplilearn.neetha.gateway.SportyShoesGateway;


@RestControllerAdvice
public class SportyShoesGlobalExceptionHandler {
	
	private static final Logger logger = LoggerFactory.getLogger(SportyShoesGlobalExceptionHandler.class);
	
	@ExceptionHandler(GlobalException.class)
	@ResponseStatus(value = HttpStatus.OK)
	public SportyShoesGateway<?> fpmsBadRequest(GlobalException e) {
	    logger.error("error occurs at ProductController", e);
	    return new SportyShoesGateway<>(HttpStatus.BAD_REQUEST, e.getMessage());
	}
	
	@ExceptionHandler(Exception.class)
	//@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	public SportyShoesGateway<?> handlerGenericError(Exception e) {
	    logger.error("error occurs at ProductController", e);
	    return new SportyShoesGateway<>(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
	}

}
