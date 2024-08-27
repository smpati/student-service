package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
@ResponseBody
public class ErrorController {
	
	@ExceptionHandler(NoParentAvailable.class)
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	public @ResponseBody ErrorResponse handleException(NoParentAvailable ex) {
		return ErrorResponse.builder().errorCode(HttpStatus.NOT_FOUND.value()).message(ex.getMessage()).build();
	}
	
	@ExceptionHandler(ParentAlreadyExist.class)
	@ResponseStatus(code = HttpStatus.CONFLICT)
	public ErrorResponse handleException(ParentAlreadyExist ex) {
		return ErrorResponse.builder().errorCode(HttpStatus.CONFLICT.value()).message(ex.getMessage()).build();
	}
	
	@ExceptionHandler(NoSuchParentExist.class)
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ErrorResponse handleException(NoSuchParentExist ex) {
		return ErrorResponse.builder().errorCode(HttpStatus.BAD_REQUEST.value()).message(ex.getMessage()).build();
	}

}
