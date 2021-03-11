package com.bossabox.vuttr.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bossabox.vuttr.api.application.ToolApplication;
import com.bossabox.vuttr.api.controller.dto.tool.ToolDTO;
import com.bossabox.vuttr.api.domain.tool.Tool;
import com.bossabox.vuttr.api.exception.CustomException;
import com.bossabox.vuttr.api.exception.ErrorDTO;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/tools")
public class ToolController {

	@Autowired
	private ToolApplication toolApplication;

	@Operation(summary = "Create a tool")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Title already exist", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorDTO.class))),
			@ApiResponse(responseCode = "201", description = "Tool create", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = Tool.class)) }),
			@ApiResponse(responseCode = "400", description = "Invalid fields", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorDTO.class))) })
	@PostMapping("/")
	public ResponseEntity<?> create(@RequestBody @Valid ToolDTO toolDTO) {
		try {
			return new ResponseEntity<>(toolApplication.create(toolDTO.createTool()), HttpStatus.CREATED);
		} catch (CustomException e) {
			return new ResponseEntity<>(e.getErros(), HttpStatus.resolve(e.getStatus()));
		}
	}

	/**
	 * 
	 * @param tag
	 * @return
	 */
	@Operation(summary = "Find list tools by tag name")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "List tools found", content =  @Content(mediaType = "application/json", 
						array = @ArraySchema(schema = @Schema(implementation = Tool.class)))) })
	@GetMapping
	public ResponseEntity<List<Tool>> findByTag(
			@Parameter(description = "tag of tool to be searched", example = "node") @RequestParam String tag) {
		System.out.println("thread: "+Thread.currentThread());	
		return new ResponseEntity<>(toolApplication.findByTag(tag), HttpStatus.OK);
	}

	
	
	
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	@Operation(summary = "Find a tool by id")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Response found Tool", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Tool.class))),

			@ApiResponse(responseCode = "404", description = "Tool not found by used id", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorDTO.class))) })
	@GetMapping(value = "/{id}")
	public ResponseEntity<Tool> findById(
			@Parameter(description = "id of tool to be searched", example = "2") @PathVariable(name = "id") Long id) {
		final Tool tool = toolApplication.findById(id);
		if (tool != null) {
			return new ResponseEntity<>(tool, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@Operation(summary = "List all tools")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "List all tools", content = @Content(mediaType = "application/json", 
					array = @ArraySchema(schema = @Schema(implementation = Tool.class)))) })
	@GetMapping(value = "/")
	public ResponseEntity<List<Tool>> all() {
		return new ResponseEntity<>(toolApplication.list(), HttpStatus.OK);
	}

	@Operation(summary = "Remove a tool by id")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "204", description = "Tool Deleted", content = @Content(mediaType = "application/json")),

			@ApiResponse(responseCode = "404", description = "Tool not found by used id", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorDTO.class))) })
	@DeleteMapping("/{id}")
	public ResponseEntity<?> remove(
			@Parameter(description = "id of tool to be deleted", example = "2") @PathVariable("id") Long id) {
		try {
			toolApplication.remove(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (CustomException e) {
			return new ResponseEntity<>(e.getErros(), HttpStatus.resolve(e.getStatus()));
		}
	}

}
