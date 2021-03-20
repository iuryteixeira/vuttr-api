package com.bossabox.vuttr.api.controller.dto.auth;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Response login token.
 * 
 * @author Iury Teixeira
 *
 */
@SuppressWarnings("serial")
@Getter
@AllArgsConstructor
public class TokenDTO implements Serializable {

	private String token;
}
