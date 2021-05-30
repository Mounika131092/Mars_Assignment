package com.mars.controller;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mars.model.Person;
import com.mars.service.PersonService;
//creating RestController
@RestController
public class PersonController 
{
//autowired the PersonService class
@Autowired
PersonService personService;
//creating a get mapping that retrieves all the persons detail from the database 
@GetMapping("/getAllPerson")
private List<Person> getAllPerson() 
{
return personService.getAllPerson();
}

//creating a get mapping that retrieves the detail of a specific person
@GetMapping("/person/{id}")
private Person getPerson(@PathVariable("id") int id) 
{
return personService.getPersonById(id);
}
//creating a delete mapping that deletes a specific person
@DeleteMapping("/deletePerson/{id}")
private void deletePerson(@PathVariable("id") int id) 
{
	personService.delete(id);
}
//creating post mapping that post the person detail in the database
@PostMapping("/addPerson")
private int savePerson(@RequestBody Person person) 
{
	personService.saveOrUpdate(person);
return person.getId();
}
@PutMapping("/updatePerson")  
private Person updatePerson(@RequestBody Person person)   
{  
	personService.saveOrUpdate(person);  
    return person;  
}  
@GetMapping("/getCount")
private  long getCount() 
{
return  personService.getCount();
}
}
