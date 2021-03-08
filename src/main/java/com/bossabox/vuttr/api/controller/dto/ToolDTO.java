package com.bossabox.vuttr.api.controller.dto;

import java.io.Serializable;
import java.util.Set;

import com.bossabox.vuttr.api.domain.tool.Tool;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The ToolDTO class is used for not show all domain object attributes
 * 
 * @author Iury Teixeira
 *
 */
@Data
@NoArgsConstructor
public class ToolDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String title;

	private String link;

	private String description;

	private Set<String> tags;

	/**
	 * This method transform this DTO instance object to domain model Tool
	 * 
	 * @return Tool
	 */
	public Tool createTool() {
		return new Tool(title, link, description, tags);
	}

}
