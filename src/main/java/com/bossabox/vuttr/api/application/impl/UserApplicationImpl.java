package com.bossabox.vuttr.api.application.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.bossabox.vuttr.api.application.UserApplication;
import com.bossabox.vuttr.api.domain.user.Role;
import com.bossabox.vuttr.api.domain.user.User;
import com.bossabox.vuttr.api.domain.user.UserRepository;
import com.bossabox.vuttr.api.exception.CustomException;

@Service
public class UserApplicationImpl implements UserApplication {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder encoder;

	@Override
	public User create(final String username, final String password) {

		//exists user validate
		if (userRepository.existsByUsername(username)) {
			throw new CustomException("username", "Nome de Usuário já cadastrado", 200);
		}

		// For this project only exist user admin
		final User user = new User(username, encoder.encode(password), Role.ADMIN);
		return userRepository.save(user);
	}

	@Override
	public User findByUsername(String username) {
		return userRepository.findByUsername(username).get();
	}

	@Override
	public Boolean existsByUsername(String username) {
		return userRepository.existsByUsername(username);
	}

	@Override
	public User login(String username, String password) {
		// TODO Auto-generated method stub
		return null;
	}

}
