package com.bossabox.vuttr.api.application.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bossabox.vuttr.api.application.ToolApplication;
import com.bossabox.vuttr.api.domain.tool.Tool;
import com.bossabox.vuttr.api.domain.tool.ToolRepository;

@Service
public class ToolApplicationImpl implements ToolApplication {
	
	@Autowired
	private ToolRepository toolRepository; 
	
	@Override
	public Tool create(Tool tool) {
		return null;
	}
}
