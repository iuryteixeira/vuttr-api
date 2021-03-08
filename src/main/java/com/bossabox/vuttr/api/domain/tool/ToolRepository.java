package com.bossabox.vuttr.api.domain.tool;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ToolRepository extends JpaRepository<Tool, Long> {
	Tool findByTitle(String title);
	List<Tool> findByTags(String tag);
}
