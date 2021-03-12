package com.bossabox.vuttr.api.application.impl;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.bossabox.vuttr.api.application.ToolApplication;
import com.bossabox.vuttr.api.domain.tool.Tool;
import com.bossabox.vuttr.api.domain.tool.ToolRepository;
import com.bossabox.vuttr.api.exception.CustomException;

/**
 * This class is responsible for exposing business operations related to Tools
 * Domain. Being able to, delegate certain operations to more specific classes.
 * 
 * @author Iury Teixeira
 *
 */
@Service
public class ToolApplicationImpl implements ToolApplication {

	@Autowired
	private ToolRepository toolRepository;

	/**
	 * Create a tool validating the name has already been used
	 * @param Tool
	 * @return Tool created
	 */
	@Override
	public Tool create(Tool tool) {
		if (toolRepository.findByTitle(tool.getTitle()) != null) {
			// if the tool name has been used
			throw new CustomException("title", "Ferramenta " + tool.getTitle() + " já cadastrada!", 200);
		}
		return toolRepository.save(tool);
	}

	/**
	 * List all tools
	 * 
	 * @return List of tools
	 */
	@Override
	public List<Tool> list() {
		return toolRepository.findAll();
	}

	/**
	 * Find tools by tag name
	 * 
	 * @return List of tools with search tag
	 */
	@Override
	public List<Tool> findByTag(String tag) {
		return toolRepository.findByTags(tag);
	}

	/**
	 * Find a tool by id
	 * 
	 * @param id Tool identifier Long type
	 * @return Tool
	 */
	@Override
	public Tool findById(Long id) {
		try {
			return toolRepository.findById(id).get();
		} catch (NoSuchElementException e) {
			return null;
		}
	}

	/**
	 * Remove a tool by id
	 * 
	 * @param id
	 */
	@Override
	public void remove(Long id) {
		try {
			toolRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new CustomException("Ferramenta não encontrada.", 404);
		}
	}
}
