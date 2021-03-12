package com.bossabox.vuttr.api.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bossabox.vuttr.api.application.UserApplication;
import com.bossabox.vuttr.api.controller.dto.auth.SignInDTO;
import com.bossabox.vuttr.api.controller.dto.auth.SignUpDTO;
import com.bossabox.vuttr.api.controller.dto.auth.TokenDTO;
import com.bossabox.vuttr.api.domain.user.User;
import com.bossabox.vuttr.api.exception.CustomException;
import com.bossabox.vuttr.api.exception.ErrorDTO;
import com.bossabox.vuttr.api.infra.security.jwt.JwtUtil;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

/**
 * 
 * @author Iury Teixeira
 *
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/auth")
public class AuthController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private UserApplication userApplication;

	@Autowired
	private JwtUtil jwtUtils;

	@Operation(summary = "Register user")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "User already exist", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorDTO.class))),
			@ApiResponse(responseCode = "201", description = "User create", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = User.class)) }) })
	@PostMapping("/signup")
	public ResponseEntity<?> createUser(@Valid @RequestBody SignUpDTO signUpDTO) {
		try {
			return new ResponseEntity<>(userApplication.create(signUpDTO.getUsername(), signUpDTO.getPassword()),
					HttpStatus.CREATED);
		} catch (CustomException e) {
			return new ResponseEntity<>(e.getErros(), HttpStatus.resolve(e.getStatus()));
		}
	}

	@Operation(summary = "Authetication user(login)")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Token returned", content = @Content(mediaType = "application/json", schema = @Schema(implementation = TokenDTO.class))),
			@ApiResponse(responseCode = "401", description = "Invalid credentials", content = {
					@Content(mediaType = "application/json") }) })
	@PostMapping("/signin")
	public ResponseEntity<TokenDTO> authenticateUser(@Valid @RequestBody SignInDTO signInDTO) {
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(signInDTO.getUsername(), signInDTO.getPassword()));
		SecurityContextHolder.getContext().setAuthentication(authentication);
		final String jwt = jwtUtils.generateJwtToken(authentication);
		return new ResponseEntity<>(new TokenDTO(jwt), HttpStatus.OK);
	}

}
