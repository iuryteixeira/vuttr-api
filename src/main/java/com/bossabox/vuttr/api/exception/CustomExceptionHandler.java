package com.bossabox.vuttr.api.exception;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		// error response body object
		final Map<String, Object> body = new HashMap<>();
		
		// errors found
		final List<ErrorDTO> erros = new ArrayList<>();

		for (FieldError fe : ex.getBindingResult().getFieldErrors()) {
			erros.add(new ErrorDTO(fe.getField(), fe.getDefaultMessage()));
		}

		body.put("erros", erros);
		return new ResponseEntity<>(body, headers, status);
	}

}
