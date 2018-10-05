package com.qa.springboot.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.springboot.Database.injuries;

@Repository
public interface injuriesRepository extends JpaRepository<injuries, Long> {
 

}
