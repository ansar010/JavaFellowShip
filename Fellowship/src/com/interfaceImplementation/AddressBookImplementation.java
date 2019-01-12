package com.interfaceImplementation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import com.models.Address;
import com.models.Person;

public class AddressBookImplementation implements AddressBook
{
	Scanner scanner=new Scanner(System.in);
	String name;
	//String path="",name;

	@Override
	public List<Person> addNewPerson() 
	{


		String flag=null;
		// check=null;
		@SuppressWarnings("rawtypes")
		List<Person> arrayList=new ArrayList();





		do
		{	
			Person person=new Person();
			Address address=new Address();
			System.out.println("enter the first name");
			String firstName=scanner.next();
			person.setFirstName(firstName);
			System.out.println("enter the last name");
			String lastName=scanner.next();
			person.setLastName(lastName);
			System.out.println("enter the city");
			String cityName=scanner.next();
			address.setCity(cityName);
			System.out.println("enter the state");
			String stateName=scanner.next();
			address.setState(stateName);
			System.out.println("enter the zip code");
			long zipCode=scanner.nextLong();
			address.setZipCode(zipCode);
			System.out.println("enter the phone number in string number");
			String phoneNumber=scanner.next();
			address.setPhoneNumber(phoneNumber);
			System.out.println("do u want to add another person in the same file");
			flag=scanner.next();
			person.setAddress(address);
			// System.out.println(person);
			arrayList.add(person);
			System.out.println(arrayList.size());
			for (int i = 0; i < arrayList.size(); i++) {
				System.out.println("list="+arrayList.get(i));
			}

			//System.out.println(arrayList);
			//		System.out.println(person);
			//person.address.s
			//FileWriteAndRead.fileWrite(person,path);
		}while(flag.equals("yes"));

		return arrayList;
	}

	@Override
	public List<Person> editExistingPerson(List<Person> personList) 
	{
		System.out.println("which person detail u want to edit");

		for (int i = 0; i < personList.size(); i++) 
		{
			System.out.println(personList.get(i));
		}
		System.out.println("enter the first name");
		name=scanner.next();
		for (int i = 0; i < personList.size(); i++) 
		{
			if(personList.get(i).getFirstName().equals(name))
			{
				System.out.println(" enter the new name for first name");
				String firstName=scanner.next();
				personList.get(i).setFirstName(firstName);

				System.out.println(" enter the new name for last name");
				String lastName=scanner.next();
				personList.get(i).setLastName(lastName);

			}
		}
		return personList;
	}

	@Override
	public List<Person> deletePersonInAddressBook(List<Person> personList)
	{
		System.out.println("which person detail u want to edit");

		for (int i = 0; i < personList.size(); i++) 
		{
			System.out.println(personList.get(i));
		}
		System.out.println("enter the first name");
		name=scanner.next();
		for (int i = 0; i < personList.size(); i++) 
		{
			if(personList.get(i).getFirstName().equals(name))
			{
				personList.remove(i);
			}
		}
		return personList;
	}

	@Override
	public void sortByZipcode(List<Person> personList)
	{
		/*
		for (int i = 0; i < personList.size(); i++)
		{
			Long ZipCode=(long) 0;
			ZipCode.compareTo(personList.get(i).getAddress().getZipCode());
		}
		System.out.println("after sort");
		System.out.println(personList);
		 */
		Collections.sort(personList);
		System.out.println(personList);
	}
	@Override
	public void sortByName(List<Person> personList) 
	{
		/*Collections.sort(personList, Comparator.comparing(Person::getFirstName()));*/
		Collections.sort(personList, new Comparator<Person>() {
			public int compare(Person v1, Person v2) {
				return v1.getFirstName().compareTo(v2.getFirstName());
			}
		});
		System.out.println(personList);
	}
	@Override
	public void printout(List<Person> personList) 
	{

		System.out.println(personList);
	}



}
