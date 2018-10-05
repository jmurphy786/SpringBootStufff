package com.qa.springboot.mySpringBootRepository;

import java.awt.print.Pageable;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.springboot.mySpringBootDatabaseApp.Order;

@Repository
public interface OrderRepo extends JpaRepository<Order, Long> {
	
	Page<Order> findByPersonId(Long personId, Pageable pageable);

}
