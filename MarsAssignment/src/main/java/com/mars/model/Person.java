package com.mars.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
//mark class as an Entity 
@Entity
//defining class name as Table name
@Table
public class Person 
{
//mark id as primary key
@Id
//defining id as column name
@Column
private int id;
//defining name as column name
@Column
private String firstName;

//defining lastname as column name
@Column
private String lastName;



public int getId() 
{
return id;
}
public void setId(int id) 
{
this.id = id;
}
public String getFirstName() 
{
return firstName;
}
public void setFirstName(String name) 
{
this.firstName = name;
}


public String getLastName() {
	return lastName;
}
public void setLastName(String lastName) {
	this.lastName = lastName;
}
}