package com.qa.springboot.mySpringBootMiniProject;


import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.qa.springboot.MySpringBootMiniProjectApplication;
import com.qa.springboot.Database.owners;
import com.qa.springboot.Repository.ownersRepository;





@RunWith(SpringRunner.class)
@SpringBootTest(classes = MySpringBootMiniProjectApplication.class)
@DataJpaTest
public class MySpringBootMiniProjectApplicationTests 
{
	@Autowired
	private TestEntityManager entityManager;
	
	@Autowired
	private ownersRepository MyRepo;
		
	@Test
	public void retrieveDataByIdTest() 
	{
		owners model1 = new owners("Bob", "Space", 50);
		entityManager.persist(model1);
		entityManager.flush();
		assertTrue(MyRepo.findById(model1.getOwnerId()).isPresent());
	}
}

