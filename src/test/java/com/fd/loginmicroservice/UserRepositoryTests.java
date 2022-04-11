package com.fd.loginmicroservice;


import static org.junit.Assert.assertEquals;

import org.hibernate.mapping.PrimaryKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import com.fd.loginmicroservice.user.User;
import com.fd.loginmicroservice.user.UserRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class UserRepositoryTests {
	
	@Autowired
	private UserRepository repo;
	
	@Autowired
	private TestEntityManager entityManager;
	
	
	public void testCreateUser() {
		
		User user = new User();
		user.setEmail("prasunmitragcp@gmail.com");
		user.setPassword("Prasun@123");
		user.setFirstname("Prasun");
		user.setLastname("Mitra");
		
		User savedUser =  repo.save(user);
		
		User existUser = entityManager.find(User.class, savedUser.getId());
		
		assertEquals(existUser.getEmail(), user.getEmail());
		
	}

}
