package com.bossabox.vuttr.api.domain.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import com.bossabox.vuttr.api.domain.AuditedEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 
 * This class represent the domain model of User and only exposes the Gettes
 * methods, so that the object is immutable.
 * 
 * Represent the users table.
 * 
 * @author Iury Teixeira
 *
 */
@Getter
@NoArgsConstructor // to JPA
@EqualsAndHashCode(callSuper = false)
@Entity(name = "users")
public class User extends AuditedEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_generator")
	@SequenceGenerator(name = "user_generator", allocationSize = 1, sequenceName = "user_seq")
	private Long id;

	@Column(nullable = false, unique = true)
	private String username;

	@JsonIgnore
	@Column(nullable = false)
	private String password;

	@Column(nullable = false)
	private Boolean active = true;

	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private Role role;

	/**
	 * All users for moment should be ADMIN
	 * 
	 * @param username
	 * @param password
	 * @param role
	 */
	public User(String username, String password, Role role) {
		super();
		this.username = username;
		this.password = password;
		this.role = role;
	}

}
