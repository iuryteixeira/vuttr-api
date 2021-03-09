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

@Service
public class ToolApplicationImpl implements ToolApplication {

	@Autowired
	private ToolRepository toolRepository;

	@Override
	public Tool create(Tool tool) {
		if (toolRepository.findByTitle(tool.getTitle()) != null) {
			throw new CustomException("title", "Ferramenta " + tool.getTitle() + " já cadastrada!", 200);
		}
		return toolRepository.save(tool);
	}

	@Override
	public List<Tool> list() {
		return toolRepository.findAll();
	}

	@Override
	public List<Tool> findByTag(String tag) {
		return toolRepository.findByTags(tag);
	}

	@Override
	public Tool findById(Long id) {
		try {
			return toolRepository.findById(id).get();
		} catch (NoSuchElementException e) {
			return null;
		}
	}

	@Override
	public void remove(Long id) {
		try {
			toolRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new CustomException("Ferramenta não encontrada.", 404);
		}
	}
}
