package com.kabeli.evaluacion.mario.echeverria;

import static org.junit.Assert.assertNotNull;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.kabeli.evaluacion.mario.echeverria.entity.User;
import com.kabeli.evaluacion.mario.echeverria.repository.IUserRepo;

@RunWith(SpringRunner.class)
@ActiveProfiles("test")
@SpringBootTest
@AutoConfigureMockMvc
public class ApplicationTests {

	
	@Autowired
	public IUserRepo userRepo;
	
	@Test
	public void testCreateUser() {
		User newUser = new User();
		newUser.setIdUser(1);
		newUser.setEmail("marioandreseche@gmail.com");
		newUser.setCreated(new Date());
		newUser.setModified(null);
		newUser.setIsactive(true);
		newUser.setLastLogin(new Date());
		newUser.setName("Mario Echeverria");
		newUser.setPassword("Prueba123");
		newUser.setPhones(null);
		
		userRepo.save(newUser);
		assertNotNull(userRepo.findById(newUser.getIdUser()).get());
	}
	
}
