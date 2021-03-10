package com.bossabox.vuttr.api.controller.dto.tool;

import java.io.Serializable;
import java.util.Set;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.bossabox.vuttr.api.domain.tool.Tool;

import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * The ToolDTO class is used for not show all domain object attributes
 * 
 * @author Iury Teixeira
 *
 */
@SuppressWarnings("serial")
@Getter
@NoArgsConstructor
public class ToolDTO implements Serializable {

	@NotBlank(message = "Título deve ser preenchido")
	private String title;

	@NotBlank(message = "Link não preenchido")
	private String link;

	@NotBlank(message = "Forneceça uma descrição para a ferramenta")
	private String description;

	@Size(min = 1, message = "Insira ao menos uma tag para a ferramenta")
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
