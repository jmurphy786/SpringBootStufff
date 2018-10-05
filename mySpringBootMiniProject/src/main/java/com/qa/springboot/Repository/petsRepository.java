package com.qa.springboot.Repository;



import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.springboot.Database.owners;
import com.qa.springboot.Database.pets;

@Repository
public interface petsRepository extends JpaRepository<pets, Long> {

	Page<pets> findPetByOwnerId(Long ownerId, Pageable pageable);
}
