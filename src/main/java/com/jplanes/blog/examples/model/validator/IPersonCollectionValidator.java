package com.jplanes.blog.examples.model.validator;

import com.jplanes.blog.examples.validations.ValidationResult;

import java.util.List;

public interface IPersonCollectionValidator extends IPersonValidator {

	List<ValidationResult> getResults();

}
