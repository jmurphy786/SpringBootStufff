package com.qa.springboot.Controller;


import java.util.List;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.springboot.Database.owners;
import com.qa.springboot.Database.pets;
import com.qa.springboot.Exceptions.ResourceNotFoundException;
import com.qa.springboot.Repository.ownersRepository;
import com.qa.springboot.Repository.petsRepository;


@RestController
@RequestMapping("/api")
public class ownersController {
	
	@Autowired
	ownersRepository ownerRepo;
	
	@Autowired
	petsRepository petsRepo;
	
	//Method to create a person
	@PostMapping("/owners")
	public owners createOwner(@Valid @RequestBody owners mSDM) {
		return ownerRepo.save(mSDM);
	}
	

	
	//Method to get a person
	@GetMapping("/owners/{id}")
	public owners getPersonById(@PathVariable(value = "id")Long ownerID) {
		return ownerRepo.findById(ownerID).orElseThrow(()-> new ResourceNotFoundException("owners", "id", ownerID));
	}
	
	
	//Method to get all people
	@GetMapping("/owners")
	public List<owners> getAllOwners(){
		return ownerRepo.findAll();
	}
	

	
	
	//Method to update a person
	@PutMapping("/owners/{id}")
	public owners updateOwner(@PathVariable(value = "id") Long ownerID, @Valid @RequestBody owners ownerDetails) {
		owners mSDM = ownerRepo.findById(ownerID).orElseThrow(()-> new ResourceNotFoundException("owners", "id", ownerID));
		mSDM.setName(ownerDetails.getName());
		mSDM.setAddress(ownerDetails.getAddress());
		mSDM.setAge(ownerDetails.getAge());
		
		owners updateData = ownerRepo.save(mSDM);
		return updateData;
	}
	
	//Method to remove a person
	@DeleteMapping("/owners/{id}")
	public ResponseEntity<?> deleteOwner(@PathVariable(value = "id") Long ownerID){
		owners mSDM = ownerRepo.findById(ownerID).orElseThrow(()-> new ResourceNotFoundException("owners", "id", ownerID));
		
		ownerRepo.delete(mSDM);
		return ResponseEntity.ok().build();
	}
	
}
