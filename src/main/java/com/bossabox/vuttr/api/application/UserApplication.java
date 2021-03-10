package com.bossabox.vuttr.api.application;

import com.bossabox.vuttr.api.domain.user.User;

public interface UserApplication {
	User create(String username, String password);
	
	User findByUsername(String username);

	Boolean existsByUsername(String username);
	
	User login(String username, String password);
}