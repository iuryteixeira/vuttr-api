package com.bossabox.vuttr.api;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.HashSet;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.bossabox.vuttr.api.application.ToolApplication;
import com.bossabox.vuttr.api.domain.tool.Tool;

/**
 * Test class for tools operations
 * @author franc
 *
 */
@SpringBootTest
public class ToolTests {

	@Autowired
	private ToolApplication toolApplication;

	@Test
	void testCreateTool() {
		final Tool tool = new Tool("Tool Sample" + System.currentTimeMillis(), "http://toolsample.com",
				"This is tool sample", new HashSet<>(Arrays.asList("https", "ssl", "programming", "tech")));
		assertThat(toolApplication.create(tool)).isInstanceOf(Tool.class);
	}

	@Test
	void testFindByTag() {
		assertThat(toolApplication.findByTag("tech")).isNotEmpty();
	}

}
