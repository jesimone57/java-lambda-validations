package com.jplanes.blog.examples.model.validator;

import com.jplanes.blog.examples.model.Person;
import com.jplanes.blog.examples.validations.ValidationResult;

import java.util.List;

public interface IPersonCollectionValidator {

	void validate(Person person);
	List<ValidationResult> getResults();
	
}
