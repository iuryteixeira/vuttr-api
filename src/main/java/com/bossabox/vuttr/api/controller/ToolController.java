package com.bossabox.vuttr.api.controller;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bossabox.vuttr.api.application.ToolApplication;
import com.bossabox.vuttr.api.controller.dto.ToolDTO;
import com.bossabox.vuttr.api.domain.tool.Tool;
import com.bossabox.vuttr.api.exception.CustomException;

@Validated
@RestController
@RequestMapping("/tools")
public class ToolController {

	@Autowired
	private ToolApplication toolApplication;

	@PostMapping("/")
	public ResponseEntity<Object> create(@RequestBody @Valid ToolDTO toolDTO) {
		try {
			return new ResponseEntity<>(toolApplication.create(toolDTO.createTool()), HttpStatus.CREATED);
		} catch (CustomException e) {
			return new ResponseEntity<>(e.getErros(), HttpStatus.resolve(e.getStatus()));
		}
	}

	@GetMapping
	public ResponseEntity<List<Tool>> findByTag(@RequestParam String tag) {
		return new ResponseEntity<>(toolApplication.findByTag(tag), HttpStatus.OK);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Tool> findById(@PathVariable(name = "id") Long id) {
		final Tool tool = toolApplication.findById(id);
		if (tool != null) {
			return new ResponseEntity<>(tool, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@GetMapping(value = "/")
	public ResponseEntity<List<Tool>> all() {
		return new ResponseEntity<>(toolApplication.list(), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Object> remove(@PathVariable("id") Long id) {
		try {
			toolApplication.remove(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (CustomException e) {
			return new ResponseEntity<>(e.getErros(), HttpStatus.resolve(e.getStatus()));
		}
	}

}
