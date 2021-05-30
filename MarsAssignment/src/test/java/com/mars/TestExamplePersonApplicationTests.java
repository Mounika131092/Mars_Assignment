package com.mars;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;

import com.mars.model.Person;
import com.mars.repository.PersonRepository;

@SpringBootTest
class TestExamplePersonApplicationTests {
	@Autowired
    private PersonRepository repo;
	@Test
	@Rollback(false)
	public void testSavePerson() {
		Person person = new Person();
		person.setId(5);
		person.setFirstName("Nikki");
		person.setLastName("King");
    Person savedPerson = repo.save(person);
    
    assertThat(savedPerson.getId()).isGreaterThan(0);
    }
	@Test
	@Rollback(false)
	public void testFindPersonbyId() {
    Person person = repo.findById(5).get();
    
    assertThat(person.getFirstName()).isEqualTo("Nikki");
    }

	public void testListPerson() {
	    List<Person> persons = (List<Person>) repo.findAll();
	    assertThat(persons).size().isGreaterThan(0);
	}
	
	@Test
	@Rollback(false)
	public void testUpdateProduct() {
		Person person = repo.findById(5).get();
		person.setLastName("Kavali");
	     
	    repo.save(person);
	     
	    Person updatedPerson = repo.findById(5).get();
	     
	    assertThat(updatedPerson.getLastName()).isEqualTo("Kavali");
	}
	@Test
	public void testCount() {
		
		assertThat(repo.count()).isGreaterThan(0);
	}
	@Test
	@Rollback(false)
	public void testDeleteProduct() {
	    Person person = repo.findById(5).get();
	     
	    repo.deleteById(person.getId());
	     
	    Person deletedPerson = repo.findById(5).get();
	     
	    assertThat(deletedPerson).isNull();       
	     
	}
}