package com.qa.springboot.Controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.springboot.Database.injuries;
import com.qa.springboot.Database.owners;
import com.qa.springboot.Exceptions.ResourceNotFoundException;
import com.qa.springboot.Repository.injuriesRepository;
import com.qa.springboot.Repository.ownersRepository;

@RestController
@RequestMapping("/api")
public class injuryController {

	@Autowired
	injuriesRepository injuryRepo;
	
	//Method to create a person
	@PostMapping("/injuries")
	public injuries createInjury(@Valid @RequestBody injuries mSDM) {
		return injuryRepo.save(mSDM);
	}
	
	//Method to get a person
	@GetMapping("/injuries/{id}")
	public injuries getInjuryById(@PathVariable(value = "id")Long injuryID) {
		return injuryRepo.findById(injuryID).orElseThrow(()-> new ResourceNotFoundException("Injuries", "id", injuryID));
	}
	
	
	//Method to get all people
	@GetMapping("/injuries")
	public List<injuries> getAllInjuries(){
		return injuryRepo.findAll();
	}
	
	
	//Method to update a person
	@PutMapping("/injuries/{id}")
	public injuries updateOwner(@PathVariable(value = "id") Long injuryID, @Valid @RequestBody injuries injuryDetails) {
		injuries mSDM = injuryRepo.findById(injuryID).orElseThrow(()-> new ResourceNotFoundException("Injuries", "id", injuryID));
		mSDM.setDescription(injuryDetails.getDescription());
		injuries updateData = injuryRepo.save(mSDM);
		return updateData;
	}
	
	//Method to remove a person
	@DeleteMapping("/injuries/{id}")
	public ResponseEntity<?> deleteOwner(@PathVariable(value = "id") Long injuryID){
		injuries mSDM = injuryRepo.findById(injuryID).orElseThrow(()-> new ResourceNotFoundException("Injury", "id", injuryID));
		injuryRepo.delete(mSDM);
		return ResponseEntity.ok().build();
	}
}
