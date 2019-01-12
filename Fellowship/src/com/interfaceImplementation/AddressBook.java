package com.interfaceImplementation;

import java.util.List;

import com.models.Person;

public interface AddressBook 
{
 List<Person> addNewPerson();
 List<Person> editExistingPerson(List<Person> list);
 List<Person> deletePersonInAddressBook(List<Person> list);
 void sortByZipcode(List<Person> list);
 void sortByName(List<Person> List);
 void printout(List<Person> person);
  
}