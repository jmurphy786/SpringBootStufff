package com.qa.springboot.Database;


import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;



@Entity
@Table(name = "pets")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"creationDate", "lastModified"}, allowGetters = true)
public class pets {


		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long petId;
		
		@NotBlank
		private String Address;
		
		@NotBlank
		private String name;
		
		private Integer age;
		
		@ManyToOne(fetch = FetchType.LAZY, optional = false)
		@JoinColumn(name = "owner_id", nullable = false)
		@OnDelete(action = OnDeleteAction.CASCADE)
		@JsonIgnore
		private owners owner;
		
		
		
	    	
		public pets(String add, String name, Integer age) 
		{
			this.Address = add;
			this.name = name;
			this.age = age;

		}
		
		public pets() {
		}
		
		
		public Long getPetId() {
			return this.petId;
		}
		
		public void setId(Long id) {
			this.petId = id;
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

		public owners getOwner() {
			return this.owner;
		}
		
		public void setOwner(owners owner) {
			this.owner = owner;
		}
		

		
}
