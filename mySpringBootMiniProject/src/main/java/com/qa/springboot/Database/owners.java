package com.qa.springboot.Database;
import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;



@Entity
@Table(name = "owners")
@EntityListeners(AuditingEntityListener.class)
public class owners implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	private String Address;
	
	@NotBlank
	private String name;
	
	private Integer age;

	
	public owners(String add, String name, Integer age) {
		this.Address = add;
		this.name = name;
		this.age = age;
	}
	
	public owners() 
	{
	}
	
	public Long getOwnerId() {
		return this.id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getAddress() {
		return this.Address;
	}
	
	public void setAddress(String address) {
		this.Address = address;
	}
	
	public Integer getAge() {
		return this.age;
	}
	
	public void setAge(Integer age) {
		this.age = age;
	}
	
//	public Integer getPetIds() {
//		return this.petId;
//	}
//	
//	public void setPetId(Integer petId) {
//		this.petId = petId;
//	}
}