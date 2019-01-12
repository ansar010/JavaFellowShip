package com.interfaceImplementation;

import java.util.List;

import com.models.Person;

public interface AddressBookManager 
{
	List<Person> createNewAddressBook(String path);
	String openAddressBook();
	void saveAddressBook(List<Person> arrayList,String path);
	void closeAddressBook(String addressBookName);

}