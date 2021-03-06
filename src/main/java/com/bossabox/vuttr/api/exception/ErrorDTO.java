package com.bossabox.vuttr.api.exception;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * This class represent the System Validation Errors.
 * 
 * @author franc
 *
 */
@AllArgsConstructor
@Getter
public class ErrorDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String field, message;

}
