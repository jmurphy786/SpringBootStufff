package com.qa.springboot;


import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.qa.springboot.mySpringBootRepository.personRepository;
import com.qa.springboot.mySpringBootDatabaseApp.mySpringBootDataModel;
import com.qa.springboot.MySpringBootApplication;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {MySpringBootApplication.class})
@DataJpaTest
public class MySpringBootApplicationTests {

	@Autowired
	private TestEntityManager entityManager;
	
		@Autowired
		private personRepository MyRepo;
		
		@Test
		public void retrieveDataByIdTest() {
			mySpringBootDataModel model1 = new mySpringBootDataModel("Bob", "Space", 50);
			entityManager.persist(model1);
			entityManager.flush();
			assertTrue(MyRepo.findById(model1.getId()).isPresent());
		}
		
		@Test
		public void retrieveDataByNameTest() {
			mySpringBootDataModel model2 = new mySpringBootDataModel("Bob", "Space", 50);
			
			entityManager.persist(model2);
			entityManager.flush();
			
			assertEquals("Bob", MyRepo.findByName("Bob").getName());
		}
		


}
