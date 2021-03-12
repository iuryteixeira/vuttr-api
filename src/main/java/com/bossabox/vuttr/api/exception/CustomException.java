package com.bossabox.vuttr.api.exception;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;

/**
 * Custom exception is used for send custom messages of API
 * 
 * @author franc
 *
 */
@Getter
public class CustomException extends RuntimeException {

	/**
	 * HTTP Status, sent in response
	 */
	private Integer status;

	/**
	 * Error list of validation
	 */
	private List<ErrorDTO> erros = new ArrayList<>();

	/**
	 * New runtime exception is created only with message and status, is not field
	 * in process.
	 * 
	 * @param message
	 * @param status
	 */
	public CustomException(String message, Integer status) {
		this.status = status;
		erros.add(new ErrorDTO(null, message));
	}

	/**
	 * New runtime exception is created for indicate a error field validation.
	 * 
	 * @param field
	 * @param message
	 * @param status
	 */
	public CustomException(String field, String message, Integer status) {
		this.status = status;
		erros.add(new ErrorDTO(field, message));
	}

}
