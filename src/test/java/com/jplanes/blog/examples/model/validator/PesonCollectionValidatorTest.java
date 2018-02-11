package com.jplanes.blog.examples.model.validator;

import com.jplanes.blog.examples.model.Person;
import com.jplanes.blog.examples.validations.ValidationResult;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class PesonCollectionValidatorTest {

	private PersonCollectionValidator validator = null;
	private Person person = null;

	@Before
	public void setUp() {
		validator = new PersonCollectionValidator();
		person = new Person("bill", "clinton", "bill@gmail.com", 60);
	}

	@Test
	public void testOk() {
		validator.validate(person);
		List<ValidationResult> results = validator.getResults();
		assertEquals(0, results.size());
	}

	@Test
	public void firstnameNull() {
		person.setFirstName(null);
		validator.validate(person);
		List<ValidationResult> results = validator.getResults();
		listResults(results);
		assertEquals(2, results.size());
		assertEquals("firstname must not be null and between 2 and 12 characters long", results.get(0).getMesssage());
		assertEquals("firstname null does not match bill or william", results.get(1).getMesssage());
	}

	@Test
	public void lastnameNull() {
		person.setLastName(null);
		validator.validate(person);
		List<ValidationResult> results = validator.getResults();
		listResults(results);
		assertEquals(1, results.size());
		assertEquals("lastname must not be null and between 4 and 30 characters long", results.get(0).getMesssage());
	}

	@Test
	public void firstnameBillOrWilliam() {
		person.setFirstName("george");
		validator.validate(person);
		List<ValidationResult> results = validator.getResults();
		listResults(results);
		assertEquals(1, results.size());
		assertEquals("firstname george does not match bill or william", results.get(0).getMesssage());
	}

	@Test
	public void email1() {
		person.setEmail("a");
		validator.validate(person);
		List<ValidationResult> results = validator.getResults();
		listResults(results);
		assertEquals(1, results.size());
		assertEquals("email : must have more than 3 chars.", results.get(0).getMesssage());
	}

	@Test
	public void age1() {
		person.setAge(200);
		validator.validate(person);
		List<ValidationResult> results = validator.getResults();
		listResults(results);
		assertEquals(1, results.size());
		assertEquals("must be lower than 110.", results.get(0).getMesssage());
	}

	private void listResults(List<ValidationResult> results) {
		results.forEach(r -> System.out.println(r.getMesssage()));
	}
}
