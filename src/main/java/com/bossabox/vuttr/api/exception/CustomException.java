package com.bossabox.vuttr.api.exception;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;

@Getter
public class CustomException extends RuntimeException {

	private Integer status;
	
	private List<ErrorDTO> erros = new ArrayList<>();

	public CustomException(String message, Integer status) {
		this.status = status;
		erros.add(new ErrorDTO(null, message));	
	}
	
	public CustomException(String field, String message, Integer status) {
		this.status = status;
		erros.add(new ErrorDTO(field, message));	
	}
	
}
