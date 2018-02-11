package com.jplanes.blog.examples.model.validator;

import com.jplanes.blog.examples.model.Person;
import com.jplanes.blog.examples.validations.ValidationResult;

import java.util.ArrayList;
import java.util.List;

import static com.jplanes.blog.examples.validations.helper.StringValidationHelpers.between;
import static com.jplanes.blog.examples.validations.helper.StringValidationHelpers.contains;
import static com.jplanes.blog.examples.validations.helper.StringValidationHelpers.matches;
import static com.jplanes.blog.examples.validations.helper.StringValidationHelpers.notNull;
import static com.jplanes.blog.examples.validations.helper.IntegerValidationHelpers.inBetween;

public class PersonCollectionValidator implements IPersonCollectionValidator {

	private List<ValidationResult> results = new ArrayList<>();

	@Override
	public void validate(Person person) {

		notNull.and(between(2, 12))
				.test(person.getFirstName()).collectIfInvalid("firstname must not be null and between 2 and 12 characters long", results);

		notNull.and(between(4, 30))
				.test(person.getLastName()).collectIfInvalid("secondname", results);


		notNull.and(between(3, 50)).and(contains("@"))
				.test(person.getEmail()).collectIfInvalid("email", results);

		inBetween(0, 110)
				.test(person.getAge()).collectIfInvalid("age", results);

		matches("bill").or(matches("william"))
				.test(person.getFirstName()).collectIfInvalid(String.format("firstname %s does not match bill or william", person.getFirstName()), results);
	}

	@Override
	public List<ValidationResult> getResults() {
		return results;
	}
}
