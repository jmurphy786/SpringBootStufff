package com.qa.springboot.Database;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "injuries")
@EntityListeners(AuditingEntityListener.class)

public class injuries {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long injuryId;
	
	@NotBlank
	private String description;
	
	
	public injuries(String description) {
		this.description = description;
	}
	
	public injuries() {
		this.description = "";
	}
	
	public Long getInjuryId() {
		return this.injuryId;
	}
	
	public void setId(Long id) {
		this.injuryId = id;
	}
	
	public String getDescription() {
		return this.description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
}
