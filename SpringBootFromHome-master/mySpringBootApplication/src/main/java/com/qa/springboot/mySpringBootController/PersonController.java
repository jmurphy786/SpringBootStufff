package com.qa.springboot.mySpringBootController;

import java.awt.print.Pageable;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.qa.springboot.mySpringBootDatabaseApp.Order;
import com.qa.springboot.mySpringBootRepository.OrderRepo;
import com.qa.springboot.mySpringBootRepository.personRepository;
import com.qa.springboot.mySpringBootDatabaseApp.mySpringBootDataModel;
import com.qa.springboot.mySpringBootException.ResouceNotFoundException;

@RestController
public class PersonController {

	@Autowired
	private OrderRepo orderRepository;
	
	@Autowired
	private personRepository mySpringBootRepo;
	
	@GetMapping("/person/{personId}/orders")
	public Page<Order> getAllOrdersByPersonId(@PathVariable (value = "person_id") Long personId, Pageable pageable){
		return orderRepository.findByPersonId(personId, pageable);
	}
	
	@PostMapping("/person/{personId}/orders")
	public Order createComment(@PathVariable (value = "personId") Long personId, @PathVariable (value = "orderId") Long orderId, 
			@Valid @RequestBody Order order) {
		return mySpringBootRepo.findById(personId).map(mySpringBootDataModel -> {
			order.setPerson(mySpringBootDataModel);
			return orderRepository.save(order);
			}).orElseThrow(() -> new ResouceNotFoundException("Person" , "id" , order));
	}
	
	@PutMapping("/person/{personId}/orders/{orderId}")
	public Order updateOrder(@PathVariable (value = "personId") Long personId, @PathVariable (value = "orderId") Long orderId, 
			@Valid @RequestBody Order orderRequest) {
		if(!mySpringBootRepo.existsById(personId)) {
			throw new ResouceNotFoundException("Person", "id", orderRequest);
		}
		return orderRepository.findById(orderId).map(order -> {
			order.setTitle(orderRequest.getTitle());
			return orderRepository.save(order);
		}).orElseThrow(() -> new ResouceNotFoundException("Person" , "id" , orderRequest));
	}
	
}
