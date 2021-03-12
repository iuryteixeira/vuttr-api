package com.bossabox.vuttr.api.application;

import java.util.List;

import com.bossabox.vuttr.api.domain.tool.Tool;

public interface ToolApplication {


	/**
	 * Create a tool validating the name has already been used
	 * @param Tool
	 * @return Tool created
	 */
	Tool create(Tool tool);

	/**
	 * Find a tool by id
	 * 
	 * @param id Tool identifier Long type
	 * @return Tool
	 */
	Tool findById(Long id);


	/**
	 * Find tools by tag name
	 * 
	 * @return List of tools with search tag
	 */
	List<Tool> findByTag(String tag);

	
	/**
	 * List all tools
	 * 
	 * @return List of tools
	 */
	List<Tool> list();


	/**
	 * Remove a tool by id
	 * 
	 * @param id
	 */
	void remove(Long id);

}
