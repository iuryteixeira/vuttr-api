package com.bossabox.vuttr.api.application;

import java.util.List;

import com.bossabox.vuttr.api.domain.tool.Tool;

public interface ToolApplication {

	Tool create(Tool tool);

	Tool findById(Long id);

	List<Tool> findByTag(String tag);

	List<Tool> list();
	
	void remove(Long id);

}
