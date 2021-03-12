package com.bossabox.vuttr.api.domain.tool;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import com.bossabox.vuttr.api.domain.AuditedEntity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 
 * This class represent the domain model of Tools and only exposes the Gettes
 * methods, so that the object is immutable.
 * 
 * The tags can't repeat.
 * 
 * Represent the tools table.
 * 
 * @author Iury Teixeira
 *
 */
@Getter
@NoArgsConstructor // to JPA
@EqualsAndHashCode(callSuper = false)
@Entity(name = "tools")
public class Tool extends AuditedEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tool_generator")
	@SequenceGenerator(name = "tool_generator", allocationSize = 1, sequenceName = "tool_seq")
	private Long id;

	@Column(nullable = false)
	private String title;

	private String link;

	private String description;

	@ElementCollection
	private Set<String> tags;

	public Tool(String title, String link, String description, Set<String> tags) {
		super();
		this.title = title;
		this.link = link;
		this.description = description;
		this.tags = tags;
	}

}
