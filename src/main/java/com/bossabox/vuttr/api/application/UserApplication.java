package com.bossabox.vuttr.api.application;

import java.util.List;

import com.bossabox.vuttr.api.domain.user.User;

public interface UserApplication {
	/**
	 * Create a new user ADMIN with cipher password in database
	 * 
	 * @param username
	 * @param password
	 * @return User created
	 */
	User create(String username, String password);

	/**
	 * Find a user by username
	 * 
	 * @param username
	 * @return User
	 */
	User findByUsername(String username);

	/**
	 * Verify is exists a User with equals username
	 * 
	 * @param username
	 * @return Boolean
	 */
	Boolean existsByUsername(String username);

	/**
	 * List all users
	 * 
	 * @return
	 */
	List<User> list();
}