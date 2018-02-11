package com.jplanes.blog.examples.model.validator;

import com.jplanes.blog.examples.model.Person;
import com.jplanes.blog.examples.validations.ValidationResult;

import java.util.ArrayList;
import java.util.List;

import static com.jplanes.blog.examples.validations.helper.IntegerValidationHelpers.inBetween;
import static com.jplanes.blog.examples.validations.helper.StringValidationHelpers.between;
import static com.jplanes.blog.examples.validations.helper.StringValidationHelpers.contains;
import static com.jplanes.blog.examples.validations.helper.StringValidationHelpers.matches;
import static com.jplanes.blog.examples.validations.helper.StringValidationHelpers.notNull;

public class PersonValidator implements IPersonValidator {

	private List<ValidationResult> results = new ArrayList<>();

	@Override
	public void validate(Person person) {


		notNull.and(between(2, 12))
				.test(person.getFirstName()).throwIfInvalid("firstname");

		notNull.and(between(4, 30))
				.test(person.getLastName()).throwIfInvalid("secondname");

		notNull.and(between(3, 50)).and(contains("@"))
				.test(person.getEmail()).throwIfInvalid("email");

		inBetween(0, 110)
				.test(person.getAge()).throwIfInvalid("age");

		matches("bill").or(matches("william"))
				.test(person.getFirstName()).throwIfInvalid("firstname");

	}
	
}
