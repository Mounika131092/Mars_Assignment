package com.mars.service;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mars.model.Person;
import com.mars.repository.PersonRepository;
//defining the business logic
@Service
public class PersonService 
{
@Autowired
PersonRepository personRepository;
//getting all person records
public List<Person> getAllPerson() 
{
List<Person> persons = new ArrayList<Person>();
personRepository.findAll().forEach(person -> persons.add(person));
return persons;
}


//getting a specific record
public Person getPersonById(int id) 
{
return personRepository.findById(id).get();
}
public void saveOrUpdate(Person person) 
{
	personRepository.save(person);
}
//deleting a specific record
public void delete(int id) 
{
	personRepository.deleteById(id);
}
public Long getCount() 
{
	return personRepository.count();
}
}