package com.example.jdbcdemo.service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.example.jdbcdemo.domain.Person;

public class PersonManagerTest {


	PersonManager personManager = new PersonManager();

	private final static String NAME_1 = "Zenek";
	private final static int YOB_1 = 1945;

	@Test
	public void checkConnection() {
		assertNotNull(personManager.getConnection());
	}

	@Test
	public void checkAdding() {

		Person person = new Person(NAME_1, YOB_1);

		personManager.clearPersons();
		assertEquals(1, personManager.addPerson(person));

		List<Person> persons = personManager.getAllPersons();
		Person personRetrieved = persons.get(0);

		assertEquals(NAME_1, personRetrieved.getName());
		assertEquals(YOB_1, personRetrieved.getYob());

	}

	@Test
	public void checkDelete() {

		Person person = new Person(NAME_1, YOB_1);

		personManager.clearPersons();
		assertEquals(1, personManager.addPerson(person));

		List<Person> persons = personManager.getAllPersons();
		Person personRetrieved = persons.get(0);

		assertEquals(NAME_1, personRetrieved.getName());
		assertEquals(YOB_1, personRetrieved.getYob());

		int personSize = persons.size();

		personManager.deletePersonByName(person.getName());
		persons = personManager.getAllPersons();
		assertEquals(personSize-1 , persons.size());
	}

	@Test
	public void checkUpdate() {

		Person person = new Person(NAME_1, YOB_1);

		personManager.clearPersons();
		assertEquals(1, personManager.addPerson(person));

		List<Person> persons = personManager.getAllPersons();
		Person personRetrieved = persons.get(0);

		assertEquals(NAME_1, personRetrieved.getName());
		assertEquals(YOB_1, personRetrieved.getYob());

		int NEW_YOB =1500;

		personManager.updatePersonYob(NAME_1,NEW_YOB);
		persons = personManager.getAllPersons();

		assertEquals(NEW_YOB,persons.get(0).getYob());
	}
}


