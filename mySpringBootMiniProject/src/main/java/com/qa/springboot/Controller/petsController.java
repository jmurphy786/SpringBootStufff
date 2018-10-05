package com.qa.springboot.Controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.qa.springboot.Database.injuries;
import com.qa.springboot.Database.owners;
import com.qa.springboot.Database.pets;
import com.qa.springboot.Exceptions.ResourceNotFoundException;
import com.qa.springboot.Repository.injuriesRepository;
import com.qa.springboot.Repository.petsRepository;

public class petsController {
	
	@Autowired
	petsRepository petsRepo;
	
	//Method to create a person
	@PostMapping("/pets")
	public pets createPet(@Valid @RequestBody pets mSDM) {
		return petsRepo.save(mSDM);
	}
	
	//Method to get a person
	@GetMapping("/pets/{id}")
	public pets getPetById(@PathVariable(value = "id")Long petID) {
		return petsRepo.findById(petID).orElseThrow(()-> new ResourceNotFoundException("Pets", "id", petID));
	}
	
	
	//Method to get all people
	@GetMapping("/pets")
	public List<pets> getAllPets(){
		return petsRepo.findAll();
	}
	
	//GetAPetByOwner
	@GetMapping("/owners/{id}/pets")
	public Page<pets> getAllPetsByOwnerId(@PathVariable (value = "owner_id") Long ownerId, Pageable pageable){
		return petsRepo.findPetByOwnerId(ownerId, pageable);
	}

	@PostMapping("/owners/{ownerId}/pets/{petId}")
	public pets createComment(@PathVariable (value = "ownerId")Long ownerId, @Valid @RequestBody pets pets) {
		return petsRepo.findById(ownerId).map(owners -> {
			pets.setOwner(owner);
			return petsRepo.save(pets);
		}).orElseThrow(() -> new ResourceNotFoundException("Pet", "id", pets));
	}
	//Method to update a person
	@PutMapping("/pets/{id}")
	public pets updatePets(@PathVariable(value = "id") Long petID, @Valid @RequestBody pets petDetails) {
		pets mSDM = petsRepo.findById(petID).orElseThrow(()-> new ResourceNotFoundException("Pets", "id", petID));
		mSDM.setAddress(petDetails.getAddress());
		mSDM.setAge(petDetails.getAge());
		mSDM.setName(petDetails.getName());
		pets updateData = petsRepo.save(mSDM);
		return updateData;
	}
	
	//Method to remove a person
	@DeleteMapping("/pets/{id}")
	public ResponseEntity<?> deletePets(@PathVariable(value = "id") Long petID){
		pets mSDM = petsRepo.findById(petID).orElseThrow(()-> new ResourceNotFoundException("Pets", "id", petID));
		petsRepo.delete(mSDM);
		return ResponseEntity.ok().build();
	}
}
