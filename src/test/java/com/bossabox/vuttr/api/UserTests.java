package com.bossabox.vuttr.api;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.bossabox.vuttr.api.application.UserApplication;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
class UserTests {

	@Autowired
	private UserApplication userApplication;

	final String username = "iury-run" + System.currentTimeMillis();

	@Test
	@Order(1)
	void testCreate() {
		assertThat(userApplication.create(username, "123123").getUsername()).isEqualTo(username);
	}

	@Test
	@Order(2)
	void testExistisUser() {
		Boolean b = userApplication.existsByUsername(username);
		System.out.println(b);
		assertThat(b).isEqualTo(true);
	}

	@Test
	@Order(3)
	void testFindUser() {
		assertThat(userApplication.findByUsername(username).getUsername()).isEqualTo(username);
	}

}
