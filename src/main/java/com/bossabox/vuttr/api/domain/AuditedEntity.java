package com.bossabox.vuttr.api.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * This class is responsible for keep audit properties of entities, createdAt,
 * updatedAt and others like: createdBy and updatedBy.
 *
 * @author Iury Teixeira
 */
@SuppressWarnings("serial")
@MappedSuperclass
@Data
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = { "createdAt", "updatedAt" }, allowGetters = true)
public abstract class AuditedEntity implements Serializable {

	@CreatedDate
	@Column(nullable = false, updatable = false)
	private Date createdAt;

	@LastModifiedDate
	private Date updatedAt;

}