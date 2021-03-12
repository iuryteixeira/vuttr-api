package com.bossabox.vuttr.api.controller.dto.auth;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Class to transfer login/auth data
 * 
 * @author franc
 *
 */
@SuppressWarnings("serial")
@Getter
@NoArgsConstructor
public class SignInDTO implements Serializable {

	@NotBlank(message = "Nome de usuário deve ser preenchido")
	private String username;
	@NotBlank(message = "Senha deve ser preenchido")
	@Size(min = 6, message = "Senha deve ter no mínimo 6 caracteres")
	private String password;
}
