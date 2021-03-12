package com.bossabox.vuttr.api;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.bossabox.vuttr.api.application.UserApplication;
import com.bossabox.vuttr.api.domain.user.User;

@SpringBootTest
class UserTests {

	@Autowired
	private UserApplication userApplication;

	private List<User> us;

	@BeforeEach
	void setup() {
		us = userApplication.list();
	}

	@Test
	void testCreateUser() {
		final String username = "user_master" + System.currentTimeMillis();
		assertThat(userApplication.create(username, "123123").getUsername()).isEqualTo(username);
	}

	@Test
	void testExistisUser() {
		if (!us.isEmpty()) {
			assertThat(userApplication.existsByUsername(us.get(0).getUsername())).isEqualTo(true);
		}
	}

	@Test
	void testFindUsername() {
		if (!us.isEmpty()) {
			assertThat(userApplication.findByUsername(us.get(0).getUsername()).getUsername())
					.isEqualTo(us.get(0).getUsername());
		}
	}

}
