package com.bossabox.vuttr.api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bossabox.vuttr.api.controller.dto.ToolDTO;
import com.bossabox.vuttr.api.domain.tool.Tool;

@RestController
@RequestMapping("/tools")
public class ToolController {

	@PostMapping("/")
	public ResponseEntity<Tool> create(@RequestBody ToolDTO toolDTO) {
		return new ResponseEntity<>(null, HttpStatus.CREATED);
	}

	@GetMapping(value = "/{tag}")
	public void findByTag(@RequestParam(name = "tag") String tag) {

	}

	@GetMapping(value = "/")
	public void all() {

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Tool> remove(@PathVariable("id") Long id) {
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}
